package com.tk.config;

import com.tk.config.swagger.bean.SwaggerInfo;
import com.tk.config.ymlbean.login.LoginProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : ConfigYMLBeanConfiguration
 * @description : [配置文件转换实体类 统一管理类]
 * @createTime : [2021/12/13 11:33]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 11:33]
 * @updateRemark : [描述说明本次修改内容]
 */
@Configuration
public class ConfigYMLBeanConfiguration {

    /**
     * login
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "login")
    //实体和yml文件映射，prefix指定前缀为login的
    public LoginProperties loginProperties(){
        return new LoginProperties();
    }

    /**
     * swagger
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "swagger")
    public SwaggerInfo swaggerInfo(){
        return new SwaggerInfo();
    }

}
