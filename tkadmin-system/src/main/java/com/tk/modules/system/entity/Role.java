package com.tk.modules.system.entity;

import com.tk.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : Role
 * @description : [角色实体类]
 * @createTime : [2021/12/31 17:21]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/31 17:21]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Role extends BaseEntity implements Serializable {
    // 角色 id
    private Long id;
    // 角色名称
    private String name;
    // 角色级别
    private Integer level;
    // 描述
    private String description;
    // 数据权限
    private String dataScope;
}
