package com.tk.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : BaseEntity
 * @description : [entity 实体 基类]
 * @createTime : [2021/12/23 15:56]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/23 15:56]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BaseEntity {
    // 创建人
    private String createBy;
    // 更新人
    private String updateBy;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
}
