package com.tk.modules.system.service;

import com.tk.modules.security.service.dto.UserDetailedInformation;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IDataScopeService
 * @description : [数据权限服务接口]
 * @createTime : [2022/1/5 16:19]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/5 16:19]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IDataScopeService {

    /**
     * 获取数据权限
     * @param userDetailedInformation
     * @return
     */
    List<Long> getDeptIds(UserDetailedInformation userDetailedInformation);
}
