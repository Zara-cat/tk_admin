package com.tk.modules.security.controller;

import cn.hutool.core.util.IdUtil;
import com.tk.config.jwt.JwtUtils;
import com.tk.config.ymlbean.login.LoginCodeEnum;
import com.tk.constant.SysJWTConstant;
import com.tk.modules.security.dto.AuthUserDTO;
import com.tk.utils.code.LoginCodeUtil;
import com.tk.utils.enums.ExecutionState;
import com.tk.utils.redis.RedisUtil;
import com.tk.utils.response.Responder;
import com.tk.utils.response.ResultDTO;
import com.wf.captcha.base.Captcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private LoginCodeUtil loginCodeUtil;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "登录授权")
    @PostMapping(value = {"/login"})
    public ResultDTO<Object> login(@Validated @RequestBody AuthUserDTO userDTO, ServletResponse response) {
        String code = (String) redisUtil.get(userDTO.getUuid());
        //清除验证码
        redisUtil.del(userDTO.getUuid());
        if (StringUtils.isBlank(code)) {
            return Responder.failure(ExecutionState.USER_NO_LOGINCODE);
        }
        if (StringUtils.isBlank(userDTO.getCode()) || !userDTO.getCode().equalsIgnoreCase(code)) {
            return Responder.failure(ExecutionState.USER_LOGINCODE_FAIL);
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userDTO.getUsername(), userDTO.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            // 登录成功，签发 JWT token
            long currentTimeMillis = System.currentTimeMillis();
            String jwtToken = JwtUtils.sign(userDTO.getUsername(), JwtUtils.SECRET, currentTimeMillis);
            // 将签发的 JWT token 设置到 HttpServletResponse 的 Header 中
            ((HttpServletResponse) response).setHeader(JwtUtils.AUTH_HEADER, jwtToken);
            // redis 存储 key:username value:当前时间搓
            redisUtil.set(SysJWTConstant.REFRESHTOKEN_PRE + userDTO.getUsername(), currentTimeMillis, SysJWTConstant.REFRESHTOKEN_TIME);
            // 这里是登录成功后需要返回的客户端信息
            return Responder.successful(ExecutionState.USER_LOGIN_SUCCESS);
        } catch (UnknownAccountException e) { //账号不存在
            return Responder.failure(ExecutionState.USER_ACCOUNT_NOT_FOUND);
        } catch (IncorrectCredentialsException e) { //账号与密码不匹配
            return Responder.failure(ExecutionState.USER_PASSWORD_ERROR);
        } catch (LockedAccountException e) { //账号已被锁定
            return Responder.failure(ExecutionState.USER_LOCKED);
        } catch (AuthenticationException e) { //其他身份验证异常
            return Responder.failure(ExecutionState.USER_AUTHENTICATION_FAIL);
        }
    }


    @ApiOperation(value = "获取验证码")
    @GetMapping("/code")
    public ResultDTO<Object> getCode() {
        // 获取验证码
        Captcha captcha = loginCodeUtil.getCaptcha();
        // 生成uuid
        String uuid = loginCodeUtil.getLoginProperties().getLoginCode().getCodeKeyPrefix() + IdUtil.simpleUUID();
        //当验证码类型为 arithmetic时且长度 >= 2 时，captcha.text()的结果有几率为浮点型
        String captchaValue = captcha.text();
        if (captcha.getCharType() - 1 == LoginCodeEnum.arithmetic.ordinal() && captchaValue.contains(".")) {
            captchaValue = captchaValue.split("\\.")[0];
        }
        //保存
        redisUtil.set(uuid, captchaValue, loginCodeUtil.getLoginProperties().getLoginCode().getExpiration(), TimeUnit.MINUTES);
        // 验证码信息
        Map<String, Object> imgResult = new HashMap<String, Object>(2) {{
            put("img", captcha.toBase64());
            put("uuid", uuid);
        }};
        return Responder.successful(imgResult);
    }
}
