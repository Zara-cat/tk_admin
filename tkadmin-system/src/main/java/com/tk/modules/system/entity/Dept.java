package com.tk.modules.system.entity;

import com.tk.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : Dept
 * @description : [部门实体类]
 * @createTime : [2021/12/31 18:11]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/31 18:11]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept extends BaseEntity implements Serializable {
    // 部门id
    private Long id;
    // 上级部门
    private Long pid;
    // 子部门数目
    private Integer subCount;
    // 部门名称
    private String name;
    // 部门排序
    private Integer deptSort;
    // 部门状态
    private Boolean enabled;
}
