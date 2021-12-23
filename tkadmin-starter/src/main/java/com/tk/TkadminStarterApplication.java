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

@RestController
@SpringBootApplication
@Api(tags = "启动：启动测试接口")
public class TkadminStarterApplication {
    @Autowired
    LoginCodeUtil loginCodeUtil;
    public static void main(String[] args) {
        SpringApplication.run(TkadminStarterApplication.class, args);
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
