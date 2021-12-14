package com.tk.config.validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : Jsr303Config
 * @description : [Hibernate Validator 配置文件]
 * @createTime : [2021/12/14 11:39]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/14 11:39]
 * @updateRemark : [描述说明本次修改内容]
 */
@Configuration
public class Jsr303Config {
    /*
    Hibernate Validator的校验模式有两种情况:
        1.快速失败（验证失败一个，快速返回错误信息）
        2.普通模式（默认，会校验完所有的属性，然后返回所有的验证失败信息）
        我们一般使用第一种，也就是校验时候验证失败的时候就及时返回,SpringBoot需要开启配置*/
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation
                .byProvider( HibernateValidator.class )
                .configure()
                .failFast( true )// 将fail_fast设置为true即可，如果想验证全部，则设置为false或者取消配置即可
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
