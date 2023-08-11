package com.ly.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.domain.entity.UserRole;
import com.ly.mapper.UserRoleMapper;
import com.ly.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户和角色关联表(UserRole)表服务实现类
 *
 * @author makejava
 * @since 2023-08-11 15:47:43
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
