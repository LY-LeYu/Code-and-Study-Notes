package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Role;
import com.ly.domain.vo.RoleVo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-08-08 16:50:08
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long id);

    ResponseResult changeStatus(Map map);

    ResponseResult getRolePage(Integer pageNum, Integer pageSize, String roleName, String status);

    ResponseResult addRole(RoleVo roleVo);

    ResponseResult getRole(Long id);

    ResponseResult updateRole(RoleVo roleVo);

    ResponseResult deleteRole(Long roleId);
}

