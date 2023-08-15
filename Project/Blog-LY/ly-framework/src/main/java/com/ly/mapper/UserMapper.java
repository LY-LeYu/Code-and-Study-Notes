package com.ly.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.domain.entity.User;
import org.springframework.stereotype.Repository;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-03 14:44:13
 */
@Repository(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {

}

