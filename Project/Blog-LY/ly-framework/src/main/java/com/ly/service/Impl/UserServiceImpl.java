package com.ly.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.domain.Dto.UserDto;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Role;
import com.ly.domain.entity.RoleMenu;
import com.ly.domain.entity.User;
import com.ly.domain.entity.UserRole;
import com.ly.domain.vo.PageVo;
import com.ly.domain.vo.UserInfoVo;
import com.ly.enums.AppHttpCodeEnum;
import com.ly.exception.SystemException;
import com.ly.mapper.UserMapper;
import com.ly.service.RoleService;
import com.ly.service.UserRoleService;
import com.ly.service.UserService;
import com.ly.utils.BeanCopyUtils;
import com.ly.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-08-06 19:19:06
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult userInfo() {
        //获取当前用户id（实际通过token获取的用户信息）
        Long userId = SecurityUtils.getUserId();
        //根据用户id查询用户信息
        User user = getById(userId);
        //封装成UserInfoVo
        UserInfoVo vo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult register(User user) {
        //对数据进行非空判断
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getPassword())) {
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getEmail())) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if (!StringUtils.hasText(user.getNickName())) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }

        //对数据进行是否存在的判断
        if (userNameExist(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (nickNameExist(user.getNickName())) {
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        if (phoneNumberExist(user.getPhoneNumber())) {
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        if (emailExist(user.getEmail())) {
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }

        //对密码进行加密
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);

        //存入数据库
        save(user);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getUserPage(Integer pageNum, Integer pageSize, String userName, String phoneNumber, String status) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //先判断name和remark是否有值
        queryWrapper.like(StringUtils.hasText(userName), User::getUserName, userName);
        queryWrapper.eq(StringUtils.hasText(phoneNumber), User::getPhoneNumber, phoneNumber);
        queryWrapper.eq(StringUtils.hasText(status), User::getStatus, status);
        //分页查询
        Page<User> page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据返回
        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Autowired
    private UserRoleService userRoleService;
    @Override
    @Transactional
    public ResponseResult addUser(User user) {
        //保存用户
        register(user);

        //保存用户和角色之间的关联
        List<Long> roleIds = user.getRoleIds();
        if (roleIds.isEmpty() || roleIds.size() > 1){
            throw new SystemException(AppHttpCodeEnum.ROLE_SET_ERROR);
        }
        Long userId = user.getId();
        UserRole userRole = new UserRole(userId, roleIds.get(0));

        userRoleService.save(userRole);

        return ResponseResult.okResult();
    }

    @Autowired
    private RoleService roleService;
    @Override
    public ResponseResult getUser(Long id) {
        User user = baseMapper.selectById(id);
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        //根据id获取role
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getUserId, id);
        UserRole userRole = userRoleService.getBaseMapper().selectOne(queryWrapper);

        Long roleId = userRole.getRoleId();
        //获取所有角色
        List<Role> roleList = roleService.list();
        UserDto userDto = new UserDto(null, roleList, userInfoVo);
        return ResponseResult.okResult(userDto);
    }

    @Override
    public ResponseResult updateUser(User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        updateById(user);
        //判断role唯一
        List<Long> roleIds = user.getRoleIds();
        if (roleIds.isEmpty() || roleIds.size() > 1){
            throw new SystemException(AppHttpCodeEnum.ROLE_SET_ERROR);
        }
        //删除之前的role和User对应关系
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getUserId, user.getId());
        userRoleService.remove(queryWrapper);
        //更新 user和role的关联
        UserRole userRole = new UserRole(user.getId(), roleIds.get(0));
        userRoleService.save(userRole);
        return ResponseResult.okResult();
    }

    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseResult deleteUser(Long userId) {
        //判断id对应User是否存在
        User user = baseMapper.selectById(userId);
        if (Objects.isNull(user)) {
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        //根据id修改逻辑删除标识
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getId, userId);
        updateWrapper.set(User::getDelFlag, 1);
        userMapper.update(null, updateWrapper);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult changeStatus(Map<String, Long> map) {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getId,map.get("userId"));
        updateWrapper.set(User::getStatus, map.get("status").toString());
        update(updateWrapper);
        return ResponseResult.okResult();
    }


    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getNickName, nickName);
        return count(queryWrapper) > 0;
    }

    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, userName);
        return count(queryWrapper) > 0;
    }

    private boolean phoneNumberExist(String phoneNumber) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhoneNumber, phoneNumber);
        return count(queryWrapper) > 0;
    }

    private boolean emailExist(String email) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getEmail, email);
        return count(queryWrapper) > 0;
    }


}
