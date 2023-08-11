package com.ly.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.domain.Dto.TagListDto;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Article;
import com.ly.domain.entity.Tag;
import com.ly.domain.vo.PageVo;
import com.ly.domain.vo.TagVo;
import com.ly.enums.AppHttpCodeEnum;
import com.ly.exception.SystemException;
import com.ly.mapper.TagMapper;
import com.ly.service.TagService;
import com.ly.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2023-08-08 13:25:53
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public ResponseResult<PageVo> getTagPage(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        //在判断tag的name和remark是否相等之前,要先判断name和remark是否有值
        queryWrapper.eq(StringUtils.hasText(tagListDto.getName()),Tag::getName,tagListDto.getName());
        queryWrapper.eq(StringUtils.hasText(tagListDto.getRemark()),Tag::getRemark,tagListDto.getRemark());
        //分页查询tag
        Page<Tag> page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据返回
        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(page.getRecords(), TagVo.class);
        PageVo pageVo = new PageVo(tagVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult deleteTag(Integer id) {
        //判断id对应Tag是否存在
        //判断id对应Tag是否存在
        Tag tag = baseMapper.selectById(id);
        if(Objects.isNull(tag)){
            throw new RuntimeException("文章不存在!");
        }
        //根据id修改逻辑删除标识
        LambdaUpdateWrapper<Tag> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Tag::getId, id);
        updateWrapper.set(Tag::getDelFlag,1);
        tagMapper.update(null,updateWrapper);
        return ResponseResult.okResult();

    }

    @Override
    public ResponseResult addTag(Tag tag) {
        //对标签名进行非空判断
        if(!(StringUtils.hasText(tag.getName()))){
            throw new SystemException(AppHttpCodeEnum.TAGNAME_NOT_NULL);
        }
        save(tag);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult selectTag(Long id) {
        //判断id对应Tag是否存在,防止伪造请求头
        Tag tag = getById(id);
        if(Objects.isNull(tag)){
            throw new SystemException(AppHttpCodeEnum.NOT_EXSIT_TAG);
        }
        TagVo tagVo = BeanCopyUtils.copyBean(tag, TagVo.class);
        return ResponseResult.okResult(tagVo);
    }

    @Override
    public ResponseResult<TagVo> updateTag(Tag tag) {
        if(!StringUtils.hasText(tag.getName())){
            throw new SystemException(AppHttpCodeEnum.TAGNAME_NOT_NULL);
        }
        updateById(tag);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult listAllTag() {
        List<Tag> tagList = list();
        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(tagList, TagVo.class);
        return ResponseResult.okResult(tagVos);
    }

}
