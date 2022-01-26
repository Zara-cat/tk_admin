package com.tk.modules.system.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : MenuVo
 * @description : [构建前端路由菜单返回VO实体]
 * @createTime : [2022/1/25 13:19]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/25 13:19]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
//这个是类注解,表示该类实例化的对象里，值为null的字段不参与序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVo implements Serializable {
    private String name;
    private String path;
    private Boolean hidden;
    private String redirect;
    private String component;
    private Boolean alwaysShow;
    private MenuMetaVo meta;
    private List<MenuVo> children;
}
