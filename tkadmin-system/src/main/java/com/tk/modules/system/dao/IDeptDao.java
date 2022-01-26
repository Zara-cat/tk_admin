package com.tk.modules.system.dao;

import com.tk.modules.system.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IDeptDao
 * @description : [部门相关持久层接口]
 * @createTime : [2022/1/10 21:31]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/10 21:31]
 * @updateRemark : [描述说明本次修改内容]
 */
@Mapper
public interface IDeptDao {
    /**
     * 根据角色 id 查询部门集合
     * @param id
     * @return
     */
    Set<Dept> selectDeptByRoleId(@Param("roleId") Long id);

    /**
     * 根据 pid 查询部门
     * @param id
     * @return
     */
    List<Dept> selectDeptByPid(@Param("pid") Long id);
}
