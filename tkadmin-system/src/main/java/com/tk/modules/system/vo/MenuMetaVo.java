package com.tk.modules.system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : MenuMetaVo
 * @description : [前端菜单路由 meta 实体类]
 * @createTime : [2022/1/25 13:35]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/25 13:35]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class MenuMetaVo {
    private String title;
    private String icon;
    private Boolean noCache;
}
