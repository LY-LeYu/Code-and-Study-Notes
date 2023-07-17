package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getAllUser(@Param("gender") String gender, @Param("age") int age);

}
