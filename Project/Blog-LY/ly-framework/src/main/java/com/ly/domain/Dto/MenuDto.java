package com.ly.domain.Dto;


import com.baomidou.mybatisplus.annotation.TableField;
import com.ly.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //set方法在设置成员变量时，会返回当前对象本身
public class MenuDto {
    //菜单ID@TableId
    private Long id;
    //菜单名称
    private String menuName;
    //菜单返回名称
    private String label;
    //父菜单ID
    private Long parentId;

    @TableField(exist = false) //添加一些表中不存在的字段,加上该注释,使mybatis不查询这些类
    public List<Menu> children;
}
