package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.User;

import java.util.Map;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-08-06 19:19:05
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);

    ResponseResult getUserPage(Integer pageNum, Integer pageSize, String userName, String phoneNumber, String status);

    ResponseResult addUser(User user);

    ResponseResult getUser(Long id);

    ResponseResult updateUser(User user);

    ResponseResult deleteUser(Long userId);

    ResponseResult changeStatus(Map<String, Long> map);
}

