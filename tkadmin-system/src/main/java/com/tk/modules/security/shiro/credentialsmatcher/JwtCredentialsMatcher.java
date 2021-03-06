package com.tk.modules.security.shiro.credentialsmatcher;

import com.tk.config.jwt.JwtUtils;
import com.tk.constant.SysJWTConstant;
import com.tk.utils.redis.RedisUtil;
import com.tk.utils.spring.SpringContextUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : JwtCredentialsMatcher
 * @description : [自定义 jwtRealm 凭证校验器]
 * @createTime : [2021/12/1 15:10]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/1 15:10]
 * @updateRemark : [描述说明本次修改内容]
 */
public class JwtCredentialsMatcher implements CredentialsMatcher {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * JwtCredentialsMatcher只需验证JwtToken内容是否合法
     */

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        RedisUtil redisUtil = (RedisUtil) SpringContextUtil.getBean("redisUtil");
        //当前用户登录token
        String token = authenticationToken.getCredentials().toString();
        //当前用户名
        String username = authenticationToken.getPrincipal().toString();
        //System.out.println(redisUtil.hasKey(SysJWTConstant.REFRESHTOKEN_PRE+username));
        //redis 中 是否有 该用户的 RefreshToken,没有就说明用户已退出，所有token无效
        if (!redisUtil.hasKey(SysJWTConstant.REFRESHTOKEN_PRE+username)){
            throw new UnknownAccountException("系统用户退出，请重新登录");
        }
        //获取redis 中 用户的 RefreshToken
        Long refreshTokenCurrent = (Long) redisUtil.get(SysJWTConstant.REFRESHTOKEN_PRE+ username);
        //获取token中的时间戳
        Long tokenCurrent = JwtUtils.getExpire(token);
        //token 和 RefreshToken 进行比较
        if (refreshTokenCurrent.equals(tokenCurrent) ){
            // 时间搓一样，判断 token 是否过期，过期就刷新token
            if (JwtUtils.overdue(token)){
                throw new ExpiredCredentialsException("token 已经过期，需要刷新");
            }
        }else{
            throw new UnknownAccountException("系统用户已经退出，无效 token 请求");
        }
        //无效token
        if (!JwtUtils.verify(token,username,JwtUtils.SECRET)){
            throw new IncorrectCredentialsException("无效 token");
        }
        //System.out.println("验证通过！！");
        return true;
    }
}
