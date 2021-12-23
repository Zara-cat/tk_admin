package com.tk.config.swagger.config;

import com.google.common.base.Predicates;
import com.tk.config.swagger.bean.SwaggerInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : SwaggerConfiguration
 * @description : [swagger配置类]
 * @createTime : [2021/12/13 14:00]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 14:00]
 * @updateRemark : [描述说明本次修改内容]
 */
@Configuration  //让Spring来加载该类配置
@EnableSwagger2 //开启swagger
@Profile({"dev", "test"}) //表明swagger只能使用在dev test 也就是开发和测试阶段
public class SwaggerConfiguration {

    @Resource
    private SwaggerInfo swaggerInfo;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerInfo.getGroupName())
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(false)
                .forCodeGeneration(true)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 设置api信息
     *
     * @return 返回ApiInfo
     */
    private ApiInfo apiInfo() {
        StringVendorExtension vendorExtension = new StringVendorExtension("", "");
        Collection<VendorExtension> vendorExtensions = new ArrayList<>();
        vendorExtensions.add(vendorExtension);
        Contact contact = new Contact("", "", "");
        return new ApiInfo(
                swaggerInfo.getTitle(),
                swaggerInfo.getDescription(),
                swaggerInfo.getVersion(),
                "", contact, "", "",
                vendorExtensions);
    }

}
