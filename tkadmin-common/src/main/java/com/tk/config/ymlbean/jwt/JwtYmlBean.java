package com.tk.config.ymlbean.jwt;

import lombok.Data;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : Jwt
 * @description : [jwt yml 配置类]
 * @createTime : [2021/12/15 17:39]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/15 17:39]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
public class JwtYmlBean {
    /**
     *  redis refreshToken prefix 默认值 RefreshToken_
     */
    private String refreshTokenPrefix = "RefreshToken_";
    /**
     * redis refreshToken valid time unit 60 minute 默认 60 分钟
     */
    private int refreshTokenTime = 3600; //60*60
    /**
     * accessToken expire time 5 minute 默认有效 5 分钟
     */
    private long accessTokenExpireTime = 5 * 60 * 1000;
    /**
     * accessToken 默认私钥
     */
    private String accessTokenSecret = "SECRET_VALUE";
    /**
     * accessToken 请求头
     */
    private String accessAuthHeader = "X-Authorization-With";
}
