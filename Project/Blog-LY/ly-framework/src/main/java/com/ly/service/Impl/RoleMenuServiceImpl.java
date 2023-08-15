package com.ly.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.domain.entity.RoleMenu;
import com.ly.mapper.RoleMenuMapper;
import com.ly.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色和菜单关联表(RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2023-08-11 11:39:08
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
