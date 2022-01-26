package com.tk.modules.system.service.impl;

import com.tk.modules.system.dao.IRoleDao;
import com.tk.modules.system.entity.Role;
import com.tk.modules.system.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : RoleServiceImpl
 * @description : [角色相关的业务层接口实现类]
 * @createTime : [2022/1/24 12:51]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 12:51]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class RoleServiceImpl implements IRoleService {
    // role dao
    private final IRoleDao roleDao;

    public RoleServiceImpl(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * 根据用户名查询用户对应的角色集合
     * @param name
     * @return
     */
    @Override
    public List<Role> findRolesByUserName(String name) {
        return roleDao.findRolesByUserName(name);
    }
}
