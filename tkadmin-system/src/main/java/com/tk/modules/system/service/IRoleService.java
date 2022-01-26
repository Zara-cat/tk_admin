package com.tk.modules.system.service;

import com.tk.modules.system.entity.Role;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IRoleService
 * @description : [角色相关的业务层接口类]
 * @createTime : [2022/1/24 12:50]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 12:50]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IRoleService {

    /**
     * 根据用户名查询用户对应的角色集合
     * @param name
     * @return
     */
    List<Role> findRolesByUserName(String name);
}
