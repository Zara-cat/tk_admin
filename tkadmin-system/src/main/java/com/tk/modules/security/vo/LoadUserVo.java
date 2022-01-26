package com.tk.modules.security.vo;

import com.tk.base.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : LoadUserVo
 * @description : [登录响应 VO 对象]
 * @createTime : [2021/12/31 19:56]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/31 19:56]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoadUserVo {
    // 可访问数据范围
    private List<Long> dataScopes;
    // 详细用户信息
    private UserDetailedInformationVo user;
    // 角色集合
    private List<String> roles;
}
