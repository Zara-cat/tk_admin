package com.tk.modules.security.vo;

import com.tk.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserDetailedInformationVo
 * @description : [用户详细信息Vo对象]
 * @createTime : [2022/1/21 14:36]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/21 14:36]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDetailedInformationVo extends BaseEntity implements Serializable {
    // 用户id
    private Long id;
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
    // 用户岗位集合
    private Set<JobVo> jobs;
    // 用户部门对象
    private DeptVo dept;
}
