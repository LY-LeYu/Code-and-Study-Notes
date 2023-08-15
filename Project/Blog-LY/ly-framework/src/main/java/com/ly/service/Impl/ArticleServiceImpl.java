package com.ly.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.constant.SystemConstants;
import com.ly.domain.Dto.AddArticleDto;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Article;
import com.ly.domain.entity.ArticleTag;
import com.ly.domain.entity.Category;
import com.ly.domain.vo.ArticleDetailVo;
import com.ly.domain.vo.HotArticleVo;
import com.ly.domain.vo.PageVo;
import com.ly.mapper.ArticleMapper;
import com.ly.service.ArticleService;
import com.ly.service.ArticleTagService;
import com.ly.service.CategoryService;
import com.ly.service.TagService;
import com.ly.utils.BeanCopyUtils;
import com.ly.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ArticleTagService articleTagService;

    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章，封装为ResponseResult类型
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件,必须正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL); //一般不允许使用字面量，要将字面量定义为常量
        //浏览量排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //设置分页
        Page<Article> page = new Page<>(1, 10);
        page(page, queryWrapper);

        List<Article> articles = page.getRecords();

        //从redis中获取viewCount
        for (Article article : articles) {
            Long id = article.getId();
            Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
            article.setViewCount(viewCount.longValue());
        }


        //使用Bean拷贝，将Article中对应的属性复制给HotArticleVo对象
//        List<HotArticleVo> articleVos = new ArrayList<>();
//        for (Article article : articles) {
//            HotArticleVo vo = new HotArticleVo();
//            BeanUtils.copyProperties(article,vo);
//            articleVos.add(vo);
//        }
        //将上述代码封装为工具类，使用
        List<HotArticleVo> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVo.class); //使用封装后的方法

        return ResponseResult.okResult(articleVos);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        // 状态是正式发布的
        wrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // 对isTop进行降序
        wrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, wrapper);

        List<Article> articles = page.getRecords();
        //从redis中获取viewCount
        for (Article article : articles) {
            Long id = article.getId();
            Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
            article.setViewCount(viewCount.longValue());
        }

        //查询categoryName
        articles.stream()
                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());
        //articleId去查询articleName进行设置
//        for (Article article : articles) {
//            Category category = categoryService.getById(article.getCategoryId());
//            article.setCategoryName(category.getName());
//        }

        //封装查询结果
        List<ArticleDetailVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleDetailVo.class);

        PageVo pageVo = new PageVo(articleListVos, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        //根据id查询文章
        Article article = getById(id);
        //从redis中获取viewCount
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        article.setViewCount(viewCount.longValue());
        //转换成VO
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        //根据分类id查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if (category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        //封装响应返回
        return ResponseResult.okResult(articleDetailVo);
    }

    @Override
    public ResponseResult updateViewCount(Long id) {
        //
        redisCache.incrementCacheMapValue("article:viewCount", id.toString(), 1);
        return null;
    }

    @Override
    @Transactional //博文增加和标签关联增加必须保证一致性
    public ResponseResult add(AddArticleDto articleDto) {
        //保存文章
        Article article = BeanCopyUtils.copyBean(articleDto, Article.class);
        save(article);

        //添加 博客和标签的关联
        List<ArticleTag> articleTags = articleDto.getTags().stream()
                .map(tagId -> new ArticleTag(article.getId(), tagId))
                .collect(Collectors.toList());
        articleTagService.saveBatch(articleTags);

        //将文章浏览量保存到redis
        updateViewCount(article.getId());


        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getArticlePage(Integer pageNum, Integer pageSize, String title, String summary) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //全匹配
//        queryWrapper.eq(StringUtils.hasText(title) , Article::getTitle, title);
//        queryWrapper.eq(StringUtils.hasText(summary) ,Article::getSummary, summary);
        //模糊匹配
        queryWrapper.like(StringUtils.hasText(title), Article::getTitle, title);
        queryWrapper.like(StringUtils.hasText(summary), Article::getSummary, summary);
        //需注意不要使用该语句判断，当输入栏为空时传入空字符串但不为null
        //queryWrapper.eq(Objects.nonNull(summary) , Article::getSummary, summary);
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL); // 状态是正式发布的

        //分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, queryWrapper);
        List<Article> articles = page.getRecords();

        //封装成vo并返回
        PageVo pageVo = new PageVo(articles, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }


    @Autowired
    private TagService tagService;
    @Override
    public ResponseResult getArticleById(Long id) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId, id);
        Article article = baseMapper.selectOne(queryWrapper);

        //查询文章对应的标签id列表
        List<Long> tagIdList = articleTagService.listById(id);

        AddArticleDto addArticleDto = BeanCopyUtils.copyBean(article, AddArticleDto.class);
        addArticleDto.setTags(tagIdList);
        return ResponseResult.okResult(addArticleDto);
    }

    @Override
    @Transactional
    public ResponseResult updateArticle(AddArticleDto articleDto) {
        Article article = BeanCopyUtils.copyBean(articleDto, Article.class);
        updateById(article);

        //删除之前的文章和tag对应关系
        articleTagService.removeOld(article.getId());

        //修改博客和标签的关联
        List<ArticleTag> articleTags = articleDto.getTags().stream()
                .map(tagId -> new ArticleTag(article.getId(), tagId))
                .collect(Collectors.toList());
        articleTagService.saveBatch(articleTags);

        //更新浏览量
        updateViewCount(article.getId());

        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult deleteArticle(Long id) {
        //判断id对应Tag是否存在
        Article article = baseMapper.selectById(id);
        if(Objects.isNull(article)){
            throw new RuntimeException("文章不存在!");
        }
        //根据id修改逻辑删除标识
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId, id);
        updateWrapper.set(Article::getDelFlag,1);
        update(null,updateWrapper);
        return ResponseResult.okResult();
    }

}
