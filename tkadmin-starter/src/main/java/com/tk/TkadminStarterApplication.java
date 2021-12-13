package com.tk;

import com.tk.config.ymlbean.login.LoginProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootApplication
@Api(tags = "启动：启动测试接口")
public class TkadminStarterApplication {
    @Resource
    LoginProperties loginProperties;
    public static void main(String[] args) {
        SpringApplication.run(TkadminStarterApplication.class, args);
    }

    // 用来测试访问
    @ApiOperation("启动类测试接口")
    @GetMapping("/")
    public String home() {
        System.out.println("启动完成");
        System.out.println(loginProperties.toString());
        return "hello tk-admin！ ";
    }
}
