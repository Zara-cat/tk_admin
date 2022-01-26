package com.tk.modules.system.service;

import com.tk.modules.system.entity.Menu;
import com.tk.modules.system.vo.MenuVo;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IMenuService
 * @description : [菜单相关业务接口类]
 * @createTime : [2022/1/24 11:47]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 11:47]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IMenuService {

    /**
     * 根据用户名 查询用户对应的前端菜单
     * @param userName
     * @return
     */
    List<MenuVo> findMenusByUser(String userName);

    /**
     * 构建菜单树
     *
     * @param menus 原始数据
     * @return /
     */
    List<Menu> buildTree(List<Menu> menus);
}
