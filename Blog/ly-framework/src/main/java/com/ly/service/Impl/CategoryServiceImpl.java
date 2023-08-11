package com.ly.service.Impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.constant.SystemConstants;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Article;
import com.ly.domain.entity.Category;
import com.ly.domain.entity.Menu;
import com.ly.domain.vo.CategoryVo;
import com.ly.domain.vo.ExcelCategoryVo;
import com.ly.domain.vo.PageVo;
import com.ly.enums.AppHttpCodeEnum;
import com.ly.exception.SystemException;
import com.ly.mapper.CategoryMapper;
import com.ly.service.ArticleService;
import com.ly.service.CategoryService;
import com.ly.utils.BeanCopyUtils;
import com.ly.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-08-02 17:00:27
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Article> articlewrapper = new LambdaQueryWrapper<>();
        articlewrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articlewrapper);

        Set<Long> categoryIds = articleList.stream()
                .map(Article::getCategoryId)
                .collect(Collectors.toSet());

        List<Category> categories = listByIds(categoryIds);

        categories = categories.stream().
                filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }

    @Override
    public ResponseResult listAllCategory() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getStatus, SystemConstants.STATUS_NORMAL);
        List<Category> list = list(wrapper);
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(list, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);

    }

    @Override
    public ResponseResult exportCategory(HttpServletResponse response) {
        try {
            //设置下载文件的请求头
            WebUtils.setDownLoadHeader("分类.xlsx",response);
            //获取需要导出的数据
            List<Category> categoryVos = list();

            List<ExcelCategoryVo> excelCategoryVos = BeanCopyUtils.copyBeanList(categoryVos, ExcelCategoryVo.class);
            //把数据写入到Excel中
            EasyExcel.write(response.getOutputStream(), ExcelCategoryVo.class).autoCloseStream(Boolean.FALSE).sheet("分类导出")
                    .doWrite(excelCategoryVos);

        } catch (Exception e) {
            //如果出现异常也要响应json
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            WebUtils.renderString(response, JSON.toJSONString(result));
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getCategoryPage(Integer pageNum, Integer pageSize, String categoryName, String status) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //在判断tag的name和remark是否相等之前,要先判断name和remark是否有值
        queryWrapper.eq(StringUtils.hasText(categoryName),Category::getName,categoryName);
        queryWrapper.eq(StringUtils.hasText(status),Category::getStatus,status);
        //分页查询tag
        Page<Category> page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据返回
        List<CategoryVo> categoryVos= BeanCopyUtils.copyBeanList(page.getRecords(),CategoryVo.class);
        PageVo pageVo = new PageVo(categoryVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult addCategory(CategoryVo categoryVo) {
        //对标签名进行非空判断
        if(!(StringUtils.hasText(categoryVo.getName()))){
            throw new SystemException(AppHttpCodeEnum.CATEGORY_ERROR);
        }
        Category category = BeanCopyUtils.copyBean(categoryVo, Category.class);
        save(category);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getCategoryById(Long id) {
        Category category = getById(id);
        if(Objects.isNull(category)){
            throw new SystemException(AppHttpCodeEnum.CATEGORY_ERROR);
        }
        CategoryVo categoryVo = BeanCopyUtils.copyBean(category, CategoryVo.class);
        return ResponseResult.okResult(categoryVo);
    }

    @Override
    public ResponseResult updateCategory(CategoryVo categoryVo) {
        if (!StringUtils.hasText(categoryVo.getName())) {
            throw new SystemException(AppHttpCodeEnum.CATEGORY_ERROR);
        }
        Category category = BeanCopyUtils.copyBean(categoryVo, Category.class);
        updateById(category);
        return ResponseResult.okResult();
    }

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResponseResult deleteCategory(Long categoryId) {
        //判断id对应Category是否存在
        Category category = baseMapper.selectById(categoryId);
        if(Objects.isNull(category) ){
            throw new SystemException(AppHttpCodeEnum.MENU_SET_ERROR);
        }
        //根据id修改逻辑删除标识
        LambdaUpdateWrapper<Category> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Category::getId, categoryId);
        updateWrapper.set(Category::getDelFlag,1);
        categoryMapper.update(null,updateWrapper);
        return ResponseResult.okResult();
    }


}
