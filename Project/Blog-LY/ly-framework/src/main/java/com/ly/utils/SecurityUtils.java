package com.ly.utils;

import com.ly.domain.entity.LoginUser;
import com.ly.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/*该工具类主要是通过Springsecurity中SecurityContextHandler获取的User对象然后再获取的id*/
public class SecurityUtils
{

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser()
    {
        return (LoginUser) getAuthentication().getPrincipal();
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Autowired
    private UserRoleService userRoleService;
    public static Boolean isAdmin(){
        Long roleId = getLoginUser().getUser().getId();
        return roleId != null && 1L == roleId;
    }

    public static Long getUserId() {
        return getLoginUser().getUser().getId();
    }
}