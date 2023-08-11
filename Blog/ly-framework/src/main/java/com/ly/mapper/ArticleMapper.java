package com.ly.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.domain.entity.Article;
import org.springframework.stereotype.Repository;

@Repository(value = "ArticleMapper")
public interface ArticleMapper extends BaseMapper<Article> {
}
