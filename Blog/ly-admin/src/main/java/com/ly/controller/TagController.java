package com.ly.controller;

import com.ly.domain.Dto.TagListDto;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Tag;
import com.ly.domain.vo.PageVo;
import com.ly.domain.vo.TagVo;
import com.ly.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<PageVo> getTagPage(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.getTagPage(pageNum,pageSize,tagListDto);
    }
    @PostMapping()
    public ResponseResult addTag(@RequestBody Tag tag){
        return tagService.addTag(tag);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable("id") Integer id) {
        return tagService.deleteTag(id);
    }
    @GetMapping("/{id}")
    public ResponseResult<TagVo> selectTag(@PathVariable("id") Long id){
        return tagService.selectTag(id);
    }

    @PutMapping
    public ResponseResult updateTag(@RequestBody Tag tag){
        return tagService.updateTag(tag);
    }

    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        return tagService.listAllTag();
    }
}