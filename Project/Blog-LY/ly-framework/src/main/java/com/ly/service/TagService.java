package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.Dto.TagListDto;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Tag;
import com.ly.domain.vo.PageVo;
import com.ly.domain.vo.TagVo;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2023-08-08 13:25:53
 */
public interface TagService extends IService<Tag> {

    ResponseResult<PageVo> getTagPage(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    ResponseResult deleteTag(Integer id);

    ResponseResult addTag(Tag tag);

    ResponseResult selectTag(Long id);

    ResponseResult<TagVo> updateTag(Tag tagVo);

    ResponseResult listAllTag();
}

