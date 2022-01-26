package com.tk.modules.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.tk.modules.system.dao.IMenuDao;
import com.tk.modules.system.entity.Menu;
import com.tk.modules.system.entity.Role;
import com.tk.modules.system.service.IMenuService;
import com.tk.modules.system.service.IRoleService;
import com.tk.modules.system.vo.MenuMetaVo;
import com.tk.modules.system.vo.MenuVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : MenuServiceImpl
 * @description : [菜单相关业务接口实现类]
 * @createTime : [2022/1/24 12:47]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 12:47]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class MenuServiceImpl implements IMenuService {

    private final IRoleService roleService;

    private final IMenuDao menuDao;

    public MenuServiceImpl(IRoleService service, IMenuDao menuDao) {
        this.roleService = service;
        this.menuDao = menuDao;
    }

    /**
     * 根据用户名 查询用户对应的前端菜单
     * @param userName
     * @return
     */
    @Override
    public List<MenuVo> findMenusByUser(String userName) {
        // 根据用户名查询用户所属的角色集合
        List<Role> roles = roleService.findRolesByUserName(userName);
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<Menu> menusList = menuDao.findMenusByRoleIdsAndTypeNot(roleIds, 2);
        List<Menu> menus = buildTree(menusList);
        return buildMenus(menus);
    }

    /**
     * 构建菜单树
     *  https://juejin.cn/post/6908920954152288270#heading-3
     * @param menus 原始数据
     * @return /
     */
    @Override
    public List<Menu> buildTree(List<Menu> menus) {
        List<Menu> tree = menus.stream()
                .filter(menu -> menu.getPid() == null)
                .map(menu -> {
                    menu.setChildren(getChildrens(menu,menus));
                    return menu;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getMenuSort() == null ? 0 : menu.getMenuSort())))
                .collect(Collectors.toList());
        return tree;
    }

    /**
     * 递归找到子类
     * @param menu
     * @param menus
     * @return
     */
    private List<Menu> getChildrens(Menu menu,List<Menu> menus){
        List<Menu> children = menus.stream()
                .filter(item -> item.getPid() == (menu.getId()))
                .map(item -> {
                    item.setChildren(getChildrens(item, menus));
                    return item;
                })
                .sorted(Comparator.comparingInt(item -> (item.getMenuSort() == null ? 0 : item.getMenuSort())))
                .collect(Collectors.toList());
        return children;
    }

    /**
     * 构建前端菜单树
     * @param menus
     * @return
     */
    private List<MenuVo> buildMenus(List<Menu> menus){
        List<MenuVo> list = new ArrayList<>();
        menus.forEach(menu -> {
            if (menu != null){
                List<Menu> childrenList = menu.getChildren();
                MenuVo menuVo = new MenuVo();
                menuVo.setName(ObjectUtil.isNotEmpty(menu.getComponentName()) ? menu.getComponentName() : menu.getTitle());
                // 一级目录需要加斜杠，不然会报警告
                menuVo.setPath(menu.getPid() == null ? "/" + menu.getPath() : menu.getPath());
                menuVo.setHidden(menu.getHidden());
                // 如果不是外链
                if (!menu.getIsFrame()){
                    if (menu.getPid() == null){
                        menuVo.setComponent(StringUtils.isEmpty(menu.getComponent()) ? "Layout" : menu.getComponent());
                    }else if (menu.getType() == 0) {
                        // 如果不是一级菜单，并且菜单类型为目录，则代表是多级菜单
                        menuVo.setComponent(StringUtils.isEmpty(menu.getComponent()) ? "ParentView" : menu.getComponent());
                    }else if (StringUtils.isNoneBlank(menu.getComponent())){
                        menuVo.setComponent(menu.getComponent());
                    }
                }
                menuVo.setMeta(new MenuMetaVo(menu.getTitle(), menu.getIcon(), !menu.getCache()));
                if (CollectionUtil.isNotEmpty(childrenList)){
                    menuVo.setAlwaysShow(true);
                    menuVo.setRedirect("noredirect");
                    menuVo.setChildren(buildMenus(childrenList));
                }else if (menu.getPid() == null){
                    // 处理是一级菜单并且没有子菜单的情况
                    MenuVo menuVo1 = new MenuVo();
                    menuVo1.setMeta(menuVo.getMeta());
                    // 非外链
                    if (!menu.getIsFrame()){
                        menuVo1.setPath("index");
                        menuVo1.setName(menuVo.getName());
                        menuVo1.setComponent(menuVo.getComponent());
                    }else {
                        menuVo1.setPath(menu.getPath());
                    }
                    menuVo.setName(null);
                    menuVo.setMeta(null);
                    menuVo.setComponent("Layout");
                    List<MenuVo> list1 = new ArrayList<>();
                    list1.add(menuVo1);
                    menuVo.setChildren(list1);
                }
                list.add(menuVo);
            }
        });
        return list;
    }
}
