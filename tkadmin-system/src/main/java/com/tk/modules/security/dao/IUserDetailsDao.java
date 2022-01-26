package com.tk.modules.security.dao;

import com.tk.modules.security.service.dto.UserDetailedInformation;
import com.tk.modules.security.service.impl.UserDetailsServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IUserDetailsDao
 * @description : [登录相关dao]
 * @createTime : [2022/1/4 17:42]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/4 17:42]
 * @updateRemark : [描述说明本次修改内容]
 */
@Mapper
public interface IUserDetailsDao {
    /**
     * 根据用户名查询用户详细信息
     * @param username
     * @return
     */
    UserDetailedInformation getUserDetailsByUsername(@Param("username") String username);
}
