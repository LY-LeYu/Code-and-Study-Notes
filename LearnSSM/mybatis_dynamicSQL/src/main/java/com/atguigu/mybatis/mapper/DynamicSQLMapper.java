package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface DynamicSQLMapper {
    public User selectUser(@Param("name") String username,@Param("age") int age);
}
