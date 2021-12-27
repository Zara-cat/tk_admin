package com.tk.modules.security.service;

import com.tk.modules.security.entity.UserInfo;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IAuthorizationService
 * @description : [授权相关的业务接口]
 * @createTime : [2021/12/24 15:59]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/24 15:59]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IAuthorizationService {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名（用户账号）
     * @return 用户信息 {@link UserInfo}
     */
    UserInfo getUserInfoByUserName(String username);
}
