package com.ly.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;
    private String userName;
    /**
     * 昵称
     */
    private String nickName;

    //账号状态（0正常 1停用）
    private String status;

    private String sex;

    private String email;

    //头像
    private String avatar;


}
