package com.ly.domain.Dto;

import com.ly.domain.entity.Role;
import com.ly.domain.vo.UserInfoVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long roleIds;

    private List<Role> roles;

    private UserInfoVo user;
}
