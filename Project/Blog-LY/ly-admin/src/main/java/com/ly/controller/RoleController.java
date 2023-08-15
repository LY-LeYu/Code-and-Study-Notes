package com.ly.controller;

import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Role;
import com.ly.domain.vo.RoleVo;
import com.ly.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public ResponseResult getRolePage(Integer pageNum, Integer pageSize, String roleName, String status) {
        return roleService.getRolePage(pageNum, pageSize, roleName, status);
    }

    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody Map<String, Long> map) {
        return roleService.changeStatus(map);
    }

    @PostMapping
    public ResponseResult addRole(@RequestBody RoleVo roleVo) {
        return roleService.addRole(roleVo);
    }

    @GetMapping("/{id}")
    public ResponseResult getRoleById(@PathVariable("id") Long id) {
        return roleService.getRole(id);
    }

    @PutMapping
    public ResponseResult updateRole(@RequestBody RoleVo roleVo) {
        return roleService.updateRole(roleVo);
    }

    @DeleteMapping("/{roleId}")
    public ResponseResult deleteRole(@PathVariable Long roleId) {
        return roleService.deleteRole(roleId);
    }

    @GetMapping("/listAllRole")
    public ResponseResult getAllRole() {
        return ResponseResult.okResult(roleService.list());
    }

}
