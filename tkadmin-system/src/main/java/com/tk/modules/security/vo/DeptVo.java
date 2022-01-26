package com.tk.modules.security.vo;

import com.tk.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : DeptVo
 * @description : [部门 vo 实体]
 * @createTime : [2022/1/21 14:38]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/21 14:38]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DeptVo extends BaseEntity implements Serializable {
    // 部门id
    private Long id;
    // 部门名称
    private String name;
}
