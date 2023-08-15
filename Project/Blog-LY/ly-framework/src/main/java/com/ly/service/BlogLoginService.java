package com.ly.service;

import com.ly.domain.ResponseResult;
import com.ly.domain.entity.User;

public interface BlogLoginService {

    ResponseResult login(User user);

    ResponseResult logout();
}
