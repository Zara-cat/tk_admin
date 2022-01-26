package com.tk.modules.system.dao;

import com.tk.modules.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IRoleDao
 * @description : [角色相关持久层接口]
 * @createTime : [2022/1/24 12:52]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 12:52]
 * @updateRemark : [描述说明本次修改内容]
 */
@Mapper
public interface IRoleDao {

    /**
     * 根据用户名查询用户对应的角色集合
     * @param username
     * @return
     */
    List<Role> findRolesByUserName(@Param("username") String username);
}
