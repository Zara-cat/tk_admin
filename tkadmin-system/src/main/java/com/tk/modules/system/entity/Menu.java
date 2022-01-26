package com.tk.modules.system.entity;

import com.tk.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : Menu
 * @description : [菜单实体类]
 * @createTime : [2022/1/24 11:50]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 11:50]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class Menu extends BaseEntity implements Serializable {
    // 菜单 id
    private Long id;
    // 上级菜单 Id
    private Long pid;
    // 子菜单数码
    private Integer subCount;
    // 菜单类型
    private Integer type;
    // 权限
    private String permission;
    // 菜单标题
    private String title;
    // 排序
    private Integer menuSort;
    // 拦截地址
    private String path;
    // 组件名称
    private String componentName;
    // 组件
    private String component;
    // 图标
    private String icon;
    // 是否外链
    private Boolean isFrame;
    // 缓存
    private Boolean cache;
    // 隐藏
    private Boolean hidden;
    // 子菜单集合
    private List<Menu> children;
}
