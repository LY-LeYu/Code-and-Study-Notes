package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-08-06 11:24:17
 */
public interface CommentService extends IService<Comment> {

    ResponseResult getCommentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}

