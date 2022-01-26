package com.tk.modules.system.dao;

import com.tk.modules.system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IMenuDao
 * @description : [菜单相关持久层接口]
 * @createTime : [2022/1/24 15:53]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 15:53]
 * @updateRemark : [描述说明本次修改内容]
 */
@Mapper
public interface IMenuDao {
    /**
     * 根据角色ID与菜单类型查询菜单
     * @param roleIds
     * @param type
     * @return
     */
    List<Menu> findMenusByRoleIdsAndTypeNot(@Param("roleIds") List<Long> roleIds,@Param("type") Integer type);
}
