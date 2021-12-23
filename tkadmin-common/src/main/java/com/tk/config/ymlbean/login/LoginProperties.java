package com.tk.config.ymlbean.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : LoginProperties
 * @description : [登录相关 yml 配置类]
 * @createTime : [2021/12/13 11:33]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 11:33]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LoginProperties {
    /**
     * 账户单用户 登录
     */
    private boolean singleLogin = false;
    /**
     * 用户登录信息缓存
     */
    private boolean cacheEnable;
    /**
     * 登录验证码相关
     */
    private LoginCode loginCode;

    public boolean isSingleLogin() {
        return singleLogin;
    }

    public boolean isCacheEnable() {
        return cacheEnable;
    }


}
