package com.ly.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenuDto {
    private List<MenuDto> menus;
    private List<Long> checkedKeys;
}
