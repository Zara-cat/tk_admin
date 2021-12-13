package com.tk.config.swagger.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : SwaggerInfo
 * @description : [SwaggerInfo yml映射实体类]
 * @createTime : [2021/12/13 13:55]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 13:55]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
public class SwaggerInfo {
    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String description;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 版本
     */
    private String version;

    /**
     * 扫描的包路径
     */
    private String basePackage;

    /**
     * 接口作者
     */
    private String author;

}
