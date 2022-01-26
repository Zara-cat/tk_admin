package com.tk.modules.security.entity;

import com.tk.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserInfo
 * @description : [用户信息实体类]
 * @createTime : [2021/12/22 20:41]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/22 20:41]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfo extends BaseEntity implements Serializable {
    // ID
    private Long id;
    // 部门id
    private Long deptId;
    // 用户名
    private String username;
    // 盐
    private String salt;
    // 密码
    private String password;
    // 昵称
    private String nickName;
    // 性别
    private String gender;
    // 手机号码
    private String phone;
    // 邮箱
    private String email;
    // 头像地址
    private String avatarName;
    // 头像真实路径
    private String avatarPath;
    // 是否为 admin 账号
    private Boolean isAdmin;
    // 状态：1启用 、0禁用
    private Long enabled;
    // 修改密码的时间
    private Date pwdResetTime;

}
