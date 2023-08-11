package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Menu;
import com.ly.domain.vo.MenuVo;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-08-08 16:46:23
 */
public interface MenuService extends IService<Menu> {

    List<String> selectPermsByUserId(Long id);

    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    ResponseResult getMenuList(String status, String menuName);

    ResponseResult addMenu(Menu menu);

    ResponseResult getMenuById(Long id);

    ResponseResult updateMenu(MenuVo menuVo);

    ResponseResult deleteMenu(Long menuId);

    ResponseResult getMenuTree();

    ResponseResult getMenuTreeById(Long id);
}

