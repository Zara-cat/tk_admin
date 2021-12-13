package com.tk.config.ymlbean.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : LoginCode
 * @description : [登录验证码 配置信息]
 * @createTime : [2021/12/13 11:32]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 11:32]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class LoginCode {
    /**
     * 验证码配置
     */
    private LoginCodeEnum codeType;
    /**
     * 验证码有效期 分钟
     */
    private Long expiration = 2L;
    /**
     * 验证码内容长度
     */
    private int Length = 2;
    /**
     * 验证码宽度
     */
    private int width = 111;
    /**
     * 验证码高度
     */
    private int height = 36;
    /**
     * 验证码字体
     */
    private String fontName;
    /**
     * 字体大小
     */
    private int fontSize = 25;
}
