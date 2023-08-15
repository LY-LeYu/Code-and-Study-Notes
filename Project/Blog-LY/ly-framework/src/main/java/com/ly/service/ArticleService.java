package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.Dto.AddArticleDto;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Article;

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);

    ResponseResult add(AddArticleDto article);

    ResponseResult getArticlePage(Integer pageNum, Integer pageSize, String title, String summary);

    ResponseResult getArticleById(Long id);

    ResponseResult updateArticle(AddArticleDto articleDto);

    ResponseResult deleteArticle(Long id);
}
