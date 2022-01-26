package com.tk.modules.security.service;

import com.tk.modules.security.vo.LoadUserVo;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IUserDetailsService
 * @description : [认证后续登录响应数据依赖接口]
 * @createTime : [2021/12/31 20:10]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/31 20:10]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IUserDetailsService {

    /**
     * 根据用户查询详细用户信息
     * @param username
     * @return
     */
    LoadUserVo loadUserByUserName(String username);
}
