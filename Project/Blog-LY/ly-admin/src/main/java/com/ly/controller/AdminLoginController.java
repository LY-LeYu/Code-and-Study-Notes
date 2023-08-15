package com.ly.controller;

import com.ly.domain.ResponseResult;
import com.ly.domain.entity.User;
import com.ly.domain.vo.AdminUserInfoVo;
import com.ly.domain.vo.RoutersVo;
import com.ly.enums.AppHttpCodeEnum;
import com.ly.exception.SystemException;
import com.ly.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController

public class AdminLoginController {
    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("/user/login")
    public ResponseResult adminLogin(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return adminLoginService.adminLogin(user);
    }

    @GetMapping("/user/getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo(){
        return adminLoginService.getInfo();
    }

    @GetMapping("/getRouters")
    public ResponseResult<RoutersVo> getRouters(){
        return adminLoginService.getRouters();
    }

    @PostMapping("/user/logout")
    public ResponseResult adminLogout(){
        return adminLoginService.adminLogout();
    }
}
