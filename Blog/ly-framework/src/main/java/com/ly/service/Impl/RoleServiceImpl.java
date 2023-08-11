package com.ly.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.*;
import com.ly.domain.vo.LinkVo;
import com.ly.domain.vo.PageVo;
import com.ly.domain.vo.RoleVo;
import com.ly.enums.AppHttpCodeEnum;
import com.ly.exception.SystemException;
import com.ly.mapper.RoleMapper;
import com.ly.service.RoleMenuService;
import com.ly.service.RoleService;
import com.ly.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-08-08 16:50:08
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public List<String> selectRoleKeyByUserId(Long userId) {
        //判断是否是管理员 如果是返回集合中只需要有admin
        if(userId == 1L){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }
        //否则查询用户所具有的角色信息
        return getBaseMapper().selectRoleKeyByUserId(userId);
    }

    @Override
    public ResponseResult getRolePage(Integer pageNum, Integer pageSize, String roleName, String status) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        //在判断name和status是否相等之前,要先判断name和remark是否有值
        queryWrapper.like(StringUtils.hasText(roleName),Role::getRoleName,roleName);
        queryWrapper.eq(StringUtils.hasText(status),Role::getStatus,status);
        queryWrapper.orderByAsc(Role::getRoleSort);
        //分页查询tag
        Page<Role> page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据返回
        List<RoleVo> roleVos = BeanCopyUtils.copyBeanList(page.getRecords(), RoleVo.class);
        PageVo pageVo = new PageVo(roleVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Autowired
    private RoleMenuService roleMenuService;
    @Override
    @Transactional
    public ResponseResult addRole(RoleVo roleVo) {
        Role role = BeanCopyUtils.copyBean(roleVo, Role.class);
        save(role);
        //添加 角色和菜单的关联
        List<RoleMenu> roleMenus = roleVo.getMenuIds().stream()
                .map(menuId -> new RoleMenu(role.getId(), menuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenus);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getRole(Long id) {
        Role role = getById(id);
        if(Objects.isNull(role)){
            throw new SystemException(AppHttpCodeEnum.LINK_ERROR);
        }
        RoleVo roleVo = BeanCopyUtils.copyBean(role, RoleVo.class);
        return ResponseResult.okResult(roleVo);
    }

    @Override
    @Transactional
    public ResponseResult updateRole(RoleVo roleVo) {
        Role role = BeanCopyUtils.copyBean(roleVo, Role.class);
        updateById(role);

        //删除之前的role和menu对应关系
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId, role.getId());
        roleMenuService.remove(queryWrapper);

        //添加 角色和菜单的关联
        List<RoleMenu> roleMenus = roleVo.getMenuIds().stream()
                .map(menuId -> new RoleMenu(role.getId(), menuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenus);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult deleteRole(Long roleId) {
        //判断id对应Tag是否存在
        Role role = baseMapper.selectById(roleId);
        if(Objects.isNull(role)){
            throw new SystemException(AppHttpCodeEnum.ROLE_NOT_EXSIST);
        }
        //根据id修改逻辑删除标识
        LambdaUpdateWrapper<Role> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Role::getId, roleId);
        updateWrapper.set(Role::getDelFlag,1);
        update(null,updateWrapper);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult changeStatus(Map map) {
        LambdaUpdateWrapper<Role> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Role::getId,map.get("roleId"));
        updateWrapper.set(Role::getStatus, map.get("status").toString());
        update(updateWrapper);
        return ResponseResult.okResult();
    }




}
