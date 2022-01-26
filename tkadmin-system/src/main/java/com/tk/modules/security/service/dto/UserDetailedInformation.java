package com.tk.modules.security.service.dto;

import com.tk.base.entity.BaseEntity;
import com.tk.modules.system.entity.Dept;
import com.tk.modules.system.entity.Job;
import com.tk.modules.system.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserDetailedInformation
 * @description : [用户详细信息 持久->业务 对象]
 * @createTime : [2022/1/4 17:51]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/4 17:51]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
public class UserDetailedInformation extends BaseEntity implements Serializable {
    // 用户id
    private Long id;
    // 用户角色集合
    private Set<Role> roles;
    // 用户岗位集合
    private Set<Job> jobs;
    // 用户部门对象
    private Dept dept;
    // 用户名
    private String username;
    // 用户昵称
    private String nickName;
    // 用户邮箱
    private String email;
    // 用户手机号
    private String phone;
    // 用户性别
    private String gender;
    // 用户头像
    private String avatarName;
    // 用户头像地址
    private String avatarPath;

}
