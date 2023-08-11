package com.ly.controller;

import com.ly.domain.ResponseResult;
import com.ly.domain.vo.CategoryVo;
import com.ly.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/content/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory() {
        return categoryService.listAllCategory();
    }

    @PreAuthorize("@permission.hasPermission('content:category:export')")
    @GetMapping("/export")
    public ResponseResult exportCategory(HttpServletResponse response) {
        return categoryService.exportCategory(response);
    }

    @GetMapping("/list")
    public ResponseResult getCategoryPage(Integer pageNum, Integer pageSize, String categoryName, String status) {
        return categoryService.getCategoryPage(pageNum,pageSize,categoryName,status);
    }

    @PostMapping
    public ResponseResult addCategory(@RequestBody CategoryVo categoryVo) {
        return categoryService.addCategory(categoryVo);
    }

    @GetMapping("/{id}")
    public ResponseResult getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping
    public ResponseResult updateCategory(@RequestBody CategoryVo categoryVo){
        return categoryService.updateCategory(categoryVo);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseResult deleteCategory(@PathVariable Long categoryId){
        return categoryService.deleteCategory(categoryId);
    }
}
