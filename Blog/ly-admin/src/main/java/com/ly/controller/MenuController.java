package com.ly.controller;

import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Menu;
import com.ly.domain.vo.MenuVo;
import com.ly.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("system/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public ResponseResult<Menu> getMenuList(String status, String menuName) {
        return menuService.getMenuList(status, menuName);
    }

    @PostMapping
    public ResponseResult addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @GetMapping("/{id}")
    public ResponseResult getMenuById(@PathVariable("id") Long id) {
        return menuService.getMenuById(id);
    }

    @PutMapping
    public ResponseResult updateMenu(@RequestBody MenuVo menuVo) {
        return menuService.updateMenu(menuVo);
    }

    @DeleteMapping("/{menuId}")
    public ResponseResult deleteMenu(@PathVariable Long menuId) {
        return menuService.deleteMenu(menuId);
    }

    @GetMapping("/treeselect")
    public ResponseResult getMenuTree() {
        return menuService.getMenuTree();
    }

    @GetMapping("/roleMenuTreeselect/{id}")
    public ResponseResult getMenuTreeById(@PathVariable("id") Long id) {
        return menuService.getMenuTreeById(id);
    }
}
