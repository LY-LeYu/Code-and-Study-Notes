package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Category;
import com.ly.domain.vo.CategoryVo;

import javax.servlet.http.HttpServletResponse;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-08-02 17:00:25
 */
public interface CategoryService extends IService<Category> {

     ResponseResult getCategoryList();


    ResponseResult listAllCategory();

    ResponseResult exportCategory(HttpServletResponse response);

    ResponseResult getCategoryPage(Integer pageNum, Integer pageSize, String categoryName, String status);

    ResponseResult addCategory(CategoryVo categoryVo);

    ResponseResult getCategoryById(Long id);

    ResponseResult updateCategory(CategoryVo categoryVo);

    ResponseResult deleteCategory(Long categoryId);
}

