package com.tk.modules.security.service.impl;

import com.tk.modules.security.dao.IAuthorizationDao;
import com.tk.modules.security.entity.UserInfo;
import com.tk.modules.security.service.IAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : AuthorizationServiceImpl
 * @description : [认证授权相关的业务实现类]
 * @createTime : [2021/12/24 16:02]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/24 16:02]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class AuthorizationServiceImpl implements IAuthorizationService {

    private final IAuthorizationDao iAuthorizationDao;

    public AuthorizationServiceImpl(IAuthorizationDao iAuthorizationDao) {
        this.iAuthorizationDao = iAuthorizationDao;
    }

    /**
     * 根据用户名查询用户信息
     * @param username 用户名（用户账号）
     * @return
     */
    @Override
    public UserInfo getUserInfoByUserName(String username) {
        return iAuthorizationDao.findUserInfoByUsername(username);
    }
}
