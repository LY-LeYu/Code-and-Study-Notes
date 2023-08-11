package com.ly.service;

import com.ly.domain.ResponseResult;
import com.ly.domain.entity.User;
import com.ly.domain.vo.AdminUserInfoVo;
import com.ly.domain.vo.RoutersVo;

public interface AdminLoginService {
    public ResponseResult adminLogin(User user);

    ResponseResult<AdminUserInfoVo> getInfo();

    ResponseResult<RoutersVo> getRouters();

    ResponseResult adminLogout();
}
