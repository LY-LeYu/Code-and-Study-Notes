package com.ly.controller;


import com.ly.domain.ResponseResult;
import com.ly.domain.vo.LinkVo;
import com.ly.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/list")
    public ResponseResult getLinkPage(Integer pageNum, Integer pageSize, String linkName, String status) {
        return linkService.getLinkPage(pageNum,pageSize,linkName,status);
    }

    @PostMapping
    public ResponseResult addLink(@RequestBody LinkVo linkVo) {
        return linkService.addLink(linkVo);
    }

    @GetMapping("/{id}")
    public ResponseResult getLinkById(@PathVariable("id") Long id) {
        return linkService.getLink(id);
    }

    @PutMapping
    public ResponseResult updateLink(@RequestBody LinkVo linkVo){
        return linkService.updateLink(linkVo);
    }

    @DeleteMapping("/{linkId}")
    public ResponseResult deleteLink(@PathVariable Long linkId){
        return linkService.deleteLink(linkId);
    }
}
