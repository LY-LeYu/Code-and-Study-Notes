package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

public interface CacheMapper {
    User getUser(@Param("id") int id);
}
