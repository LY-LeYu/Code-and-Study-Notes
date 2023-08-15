package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.entity.ArticleTag;

import java.util.List;


/**
 * 文章标签关联表(ArticleTag)表服务接口
 *
 * @author makejava
 * @since 2023-08-10 09:52:24
 */
public interface ArticleTagService extends IService<ArticleTag> {


    List<Long> listById(Long id);

    void removeOld(Long id);
}

