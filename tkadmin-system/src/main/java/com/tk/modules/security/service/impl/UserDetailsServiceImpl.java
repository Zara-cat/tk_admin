package com.tk.modules.security.service.impl;

import com.tk.base.service.IBaseGenerator;
import com.tk.modules.security.dao.IUserDetailsDao;
import com.tk.modules.security.service.IUserDetailsService;
import com.tk.modules.security.service.dto.UserDetailedInformation;
import com.tk.modules.security.vo.LoadUserVo;
import com.tk.modules.security.vo.UserDetailedInformationVo;
import com.tk.modules.system.entity.Role;
import com.tk.modules.system.service.IDataScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserDetailsServiceImpl
 * @description : [登录相关业务]
 * @createTime : [2022/1/4 17:39]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/4 17:39]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class UserDetailsServiceImpl implements IUserDetailsService {
    @Autowired
    private IUserDetailsDao dao;
    @Autowired
    private IDataScopeService iDataScopeService;
    @Autowired
    private IBaseGenerator baseGenerator;
    /**
     * 根据用户名构建 用户详细信息
     * @param username
     * @return {@link LoadUserVo}
     */
    @Override
    public LoadUserVo loadUserByUserName(String username) {
        //根据用户名查询用户信息
        UserDetailedInformation userDetailsByUsername = dao.getUserDetailsByUsername(username);
        //获取数据权限
        List<Long> deptIds = iDataScopeService.getDeptIds(userDetailsByUsername);
        LoadUserVo vo = new LoadUserVo();
        UserDetailedInformationVo userDetailedInformationVo = baseGenerator.convert(userDetailsByUsername, UserDetailedInformationVo.class);
        vo.setUser(userDetailedInformationVo)
                .setDataScopes(deptIds)
                .setRoles(userDetailsByUsername.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()));
        return vo;
    }


}
