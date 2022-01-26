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
 * @className : JobVo
 * @description : [工作岗位 vo实体]
 * @createTime : [2022/1/21 14:36]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/21 14:36]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class JobVo extends BaseEntity implements Serializable {
    // id
    private Long id;
    // 岗位名称
    private String name;
}
