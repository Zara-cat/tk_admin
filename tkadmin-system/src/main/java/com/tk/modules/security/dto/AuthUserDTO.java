package com.tk.modules.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;
    /**
     * uuid
     */
    private String uuid ="";
}
