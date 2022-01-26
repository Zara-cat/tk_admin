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
 * @className : Job
 * @description : [描述说明该类的功能]
 * @createTime : [2022/1/4 18:00]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/4 18:00]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class Job extends BaseEntity implements Serializable {
    // id
    private Long id;
    // 岗位名称
    private String name;
    // 岗位状态
    private Boolean enabled;
    // 排序
    private Integer jobSort;
}
