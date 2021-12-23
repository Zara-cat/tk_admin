package com.tk.constant;

import com.tk.config.ymlbean.jwt.JwtYmlBean;
import com.tk.utils.spring.SpringContextUtil;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : SysConstant
 * @description : [jwt相关常量]
 * @createTime : [2021/12/4 23:25]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/4 23:25]
 * @updateRemark : [描述说明本次修改内容]
 */
public class SysJWTConstant {
    //redis refreshToken prefix
    public final static String REFRESHTOKEN_PRE;
    //redis refreshToken valid time unit 60 minute
    public final static int REFRESHTOKEN_TIME;
    //client accessToken valid time 5 minute
    public final static long ACCESSToken_EXPIRE_TIME;
    //accessToken private key
    public final static String ACCESSToken_SECRET;
    //client request header need with
    public final static String ACCESS_AUTH_HEADER;

    //YML 初始化相关jwt常量值
    static {
        // 获取 JwtYmlBean 对象 ，进行赋值
        JwtYmlBean jwtYmlBean = SpringContextUtil.getBean(JwtYmlBean.class);
        REFRESHTOKEN_PRE = jwtYmlBean.getRefreshTokenPrefix();
        REFRESHTOKEN_TIME = jwtYmlBean.getRefreshTokenTime();
        ACCESSToken_EXPIRE_TIME = jwtYmlBean.getAccessTokenExpireTime();
        ACCESSToken_SECRET = jwtYmlBean.getAccessTokenSecret();
        ACCESS_AUTH_HEADER = jwtYmlBean.getAccessAuthHeader();
    }

}
