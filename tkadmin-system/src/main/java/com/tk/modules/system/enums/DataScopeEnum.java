package com.tk.modules.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : DataScopeEnum
 * @description : [数据权限枚举类]
 * @createTime : [2022/1/5 16:22]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/5 16:22]
 * @updateRemark : [描述说明本次修改内容]
 */
@Getter
@AllArgsConstructor
@ToString
public enum DataScopeEnum {
    /* 全部的数据权限 */
    ALL("全部", "全部的数据权限"),

    /* 自己部门的数据权限 */
    THIS_LEVEL("本级", "自己部门的数据权限"),

    /* 自定义的数据权限 */
    CUSTOMIZE("自定义", "自定义的数据权限");

    private final String value;
    private final String description;

    /**
     * 为了switch使用 枚举
     * @param
     * @return
     */
    public static DataScopeEnum getDataScopeEnum(String value){
        for(DataScopeEnum object:DataScopeEnum.values()){
            if(object.getValue().equals(value)){
                return object;
            }
        }
        return null;
    }
}
