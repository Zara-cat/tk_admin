package com.tk;

import com.tk.config.jwt.JwtUtils;
import com.tk.utils.code.LoginCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : AppRun
 * @description : [描述说明该类的功能]
 * @createTime : [2022/1/26 22:34]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/26 22:34]
 * @updateRemark : [描述说明本次修改内容]
 */
@RestController
@SpringBootApplication
@Api(tags = "启动：启动测试接口")
public class AppRun {
    @Autowired
    LoginCodeUtil loginCodeUtil;
    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

    // 用来测试访问
    @ApiOperation("启动类测试接口")
    @GetMapping("/")
    public String home() {
        System.out.println("启动完成");
        System.out.println(loginCodeUtil.toString());
        System.out.println(JwtUtils.AUTH_HEADER);
        return "hello tk-admin！ ";
    }
}
