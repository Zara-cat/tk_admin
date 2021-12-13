package com.tk.modules.security.controller;

import com.tk.utils.response.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : AuthorizationController
 * @description : [认证授权控制层]
 * @createTime : [2021/12/13 13:39]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 13:39]
 * @updateRemark : [描述说明本次修改内容]
 */
@RestController
@RequestMapping("/auth")
@Api(tags = "系统：系统授权接口")
public class AuthorizationController {

    @ApiOperation(value = "登录授权")
    @GetMapping(value = {"/login"})
    public ResultDTO<Object> login(){
        System.out.println("lall");
        return null;
    }
}
