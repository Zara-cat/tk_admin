package com.tk.modules.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : AuthUserDTO
 * @description : [认证授权 user DTO]
 * @createTime : [2021/12/13 14:37]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 14:37]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AuthUserDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;
    /**
     * uuid
     */
    private String uuid ="";
}
