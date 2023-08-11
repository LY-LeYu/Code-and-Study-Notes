package com.ly.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.constant.SystemConstants;
import com.ly.domain.Dto.MenuDto;
import com.ly.domain.Dto.RoleMenuDto;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Menu;
import com.ly.domain.entity.RoleMenu;
import com.ly.domain.vo.MenuVo;
import com.ly.enums.AppHttpCodeEnum;
import com.ly.exception.SystemException;
import com.ly.mapper.MenuMapper;
import com.ly.service.MenuService;
import com.ly.service.RoleMenuService;
import com.ly.utils.BeanCopyUtils;
import com.ly.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 菜单权限表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2023-08-08 16:46:23
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public List<String> selectPermsByUserId(Long userId) {
        //如果是管理员，返回所有的权限
        if(userId == 1L){
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(Menu::getMenuType, SystemConstants.MENU,SystemConstants.BUTTON);
            wrapper.eq(Menu::getStatus,SystemConstants.STATUS_NORMAL);
            List<Menu> menus = list(wrapper);
            List<String> perms = menus.stream()
                    .map(Menu::getPerms)
                    .collect(Collectors.toList());
            return perms;
        }
        //否则返回所具有的权限
        return getBaseMapper().selectPermsByUserId(userId);
    }

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {
        MenuMapper menuMapper = getBaseMapper();
        List<Menu> menus = null;
        //判断是否是管理员
        if(SecurityUtils.isAdmin()){
            //如果是 获取所有符合要求的Menu
            menus = menuMapper.selectAllRouterMenu();
        }else{
            //否则  获取当前用户所具有的Menu
            menus = menuMapper.selectRouterMenuTreeByUserId(userId);
        }
        //根据用户id查询role对应的menu
        List<Menu> menuTree = builderMenuTree(menus,0L);
        return menuTree;
    }

    @Override
    public ResponseResult getMenuList(String status, String menuName) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(status),Menu::getStatus,status);
        queryWrapper.like(StringUtils.hasText(menuName),Menu::getMenuName,menuName);
        queryWrapper.orderByAsc(Menu::getParentId,Menu::getOrderNum);
        List<Menu> menuList = list(queryWrapper);
        return ResponseResult.okResult(menuList);
    }

    @Override
    public ResponseResult addMenu(Menu menu) {
        //对标签名进行非空判断
        if(!(StringUtils.hasText(menu.getMenuName())
                || StringUtils.hasText(menu.getOrderNum().toString())
                || StringUtils.hasText(menu.getPath()) )  ){
            throw new SystemException(AppHttpCodeEnum.TAGNAME_NOT_NULL);
        }
        save(menu);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getMenuById(Long id) {
        Menu menu = getById(id);
        if(Objects.isNull(menu)){
            throw new SystemException(AppHttpCodeEnum.NOT_EXSIT_TAG);
        }
        MenuVo menuVo = BeanCopyUtils.copyBean(menu, MenuVo.class);
        return ResponseResult.okResult(menuVo);
    }

    @Override
    public ResponseResult updateMenu(MenuVo menuVo) {

        if (menuVo.getParentId().equals(menuVo.getId())) {
            throw new SystemException(AppHttpCodeEnum.MENU_SET_ERROR);
        }
        Menu menu = BeanCopyUtils.copyBean(menuVo, Menu.class);
        updateById(menu);
        return ResponseResult.okResult();
    }

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public ResponseResult deleteMenu(Long menuId) {
        //判断id对应Menu是否存在
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getParentId,menuId);
        List<Menu> childList = list(wrapper);

        //判断id对应Menu是否存在
        Menu menu = baseMapper.selectById(menuId);
        if(Objects.isNull(menu) || !childList.isEmpty() ){
            throw new SystemException(AppHttpCodeEnum.MENU_SET_ERROR);
        }

        //根据id修改逻辑删除标识
        LambdaUpdateWrapper<Menu> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Menu::getId, menuId);
        updateWrapper.set(Menu::getDelFlag,1);
        menuMapper.update(null,updateWrapper);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getMenuTree() {

        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Menu::getParentId,Menu::getOrderNum);
        List<Menu> menuList = list(queryWrapper);
        //将menuList中所有label名赋值，前端要求的字段是label
        List<Menu> menus = menuList.stream()
                .map(menu -> menu.setLabel(menu.getMenuName()))
                .collect(Collectors.toList());
        List<Menu> menuTree = builderMenuTree(menuList, 0L);
        return ResponseResult.okResult(menuTree);
    }

    @Autowired
    private RoleMenuService roleMenuService;
    @Override
    public ResponseResult getMenuTreeById(Long id) {
        //根据角色id查找对应checkedMenuId
        List<RoleMenu> roleMenuList;
        if(id == 1){
            roleMenuList = roleMenuService.list();
        }else{
            //否则获取当前用户id所具有的Menu
            LambdaQueryWrapper<RoleMenu> roleMenuLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roleMenuLambdaQueryWrapper.eq(RoleMenu::getRoleId, id);
            roleMenuList = roleMenuService.list(roleMenuLambdaQueryWrapper);
        }

        List<Long> checkedMenuIds = roleMenuList.stream()
                .map(roleMenu -> roleMenu.getMenuId())
                .collect(Collectors.toList());

        //查找menu并构建Tree
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Menu::getParentId,Menu::getOrderNum);
        List<Menu> menuList = list(queryWrapper);

        //将menuList中所有label名赋值，前端要求的字段是label
        List<Menu> menus = menuList.stream()
                .map(menu -> menu.setLabel(menu.getMenuName()))
                .collect(Collectors.toList());
        List<Menu> menuTree = builderMenuTree(menuList, 0L);

        //封装数据
        List<MenuDto> menuDtos = BeanCopyUtils.copyBeanList(menuTree, MenuDto.class);
        RoleMenuDto roleMenuDto = new RoleMenuDto(menuDtos, checkedMenuIds);

        return ResponseResult.okResult(roleMenuDto);
    }















    //以下为构造数据结构的服务
    private List<Menu> builderMenuTree(List<Menu> menus, long parentId) {
        List<Menu> menuTree = menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId)) //找到根节点
                .map(menu -> menu.setChildren(getChildren(menu, menus))) //调用getChildren方法，找子menu设置为对应根节点的children
                .collect(Collectors.toList());
        return menuTree;
    }

    private List<Menu> getChildren(Menu menu, List<Menu> menus) {
        List<Menu> childrenList = menus.stream()
                .filter(m -> m.getParentId().equals(menu.getId())) //同时作为递归结束推断语句
                .map(m->m.setChildren(getChildren(m,menus))) //递归调用本身，把所有的子menu找到
                .collect(Collectors.toList());
        return childrenList;
    }


}
