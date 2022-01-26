package com.tk.modules.system.service;

import com.tk.modules.system.entity.Dept;

import java.util.List;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IDeptService
 * @description : [部门相关 service]
 * @createTime : [2022/1/10 21:26]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/10 21:26]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IDeptService {

    /**
     * 根据角色 id 查询 部门集合
     * @param id
     * @return
     */
    Set<Dept> findByRoleId(Long id);

    /**
     * 根据 Pid 查询 部门
     * @param id
     * @return 部门集合
     */
    List<Dept> findByPid(Long id);

    /**
     * 根据部门集合 获取其项的子部门 id 集合
     * @param deptList
     * @return
     */
    List<Long> getDeptChildren(List<Dept> deptList);
}
