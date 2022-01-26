package com.tk.modules.security.dao;

import com.tk.modules.security.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : AuthorizationDao
 * @description : [认证授权相关的持久层接口]
 * @createTime : [2021/12/24 16:04]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/24 16:04]
 * @updateRemark : [描述说明本次修改内容]
 */
@Mapper
public interface IAuthorizationDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserInfo findUserInfoByUsername(@Param("username") String username);

}
