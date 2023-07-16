package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    int insertUser();
    int deleteUser();
    int updateUser();

    User selectUser();

    List<User> selectAllUser();


}
