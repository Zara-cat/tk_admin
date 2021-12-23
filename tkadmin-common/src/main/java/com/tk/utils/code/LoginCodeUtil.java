package com.tk.utils.code;

import com.tk.config.ymlbean.login.LoginCode;
import com.tk.config.ymlbean.login.LoginCodeEnum;
import com.tk.config.ymlbean.login.LoginProperties;
import com.tk.exception.custom.BadConfigurationException;
import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.awt.*;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : LoginCodeUtil
 * @description : [登录验证码相关工具类]
 * @createTime : [2021/12/15 0:22]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/15 0:22]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Component
public class LoginCodeUtil {
    @Autowired
    private LoginProperties loginProperties;

    /**
     * 获取验证码生产类
     * @return
     */
    public Captcha getCaptcha(){
        if (ObjectUtils.isEmpty(loginProperties)){
            LoginProperties loginProperties = new LoginProperties();
            if (ObjectUtils.isEmpty(loginProperties.getLoginCode().getCodeType())){
                loginProperties.getLoginCode().setCodeType(LoginCodeEnum.arithmetic);
            }
        }
        return switchCaptcha(loginProperties.getLoginCode());
    }

    /**
     * 根据 yml 配置 信息生成验证码
     * @param loginCode yml 文件中验证码配置信息
     * @return
     */
    private Captcha switchCaptcha(LoginCode loginCode){
        Captcha captcha;
        synchronized (this){
            switch (loginCode.getCodeType()){
                case arithmetic:
                    //算术类型
                    captcha = new FixedArithmeticCaptcha(loginCode.getWidth(),loginCode.getHeight());
                    // 几位数运算，默认是两位
                    captcha.setLen(loginCode.getLength());
                    break;
                case chinese:
                    captcha = new ChineseCaptcha(loginCode.getWidth(),loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case chinese_gif:
                    captcha = new ChineseGifCaptcha(loginCode.getWidth(),loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case gif:
                    captcha = new GifCaptcha(loginCode.getWidth(),loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                case spec:
                    captcha = new SpecCaptcha(loginCode.getWidth(),loginCode.getHeight());
                    captcha.setLen(loginCode.getLength());
                    break;
                default:
                    throw new BadConfigurationException("验证码配置信息错误！正确配置查看 LoginCodeEnum");
            }
            if (StringUtils.isNotBlank(loginCode.getFontName())){
                captcha.setFont(new Font(loginCode.getFontName(),Font.PLAIN,loginCode.getFontSize()));
            }
        }
        return captcha;
    }
    static class FixedArithmeticCaptcha extends ArithmeticCaptcha {
        public FixedArithmeticCaptcha(int width, int height) {
            super(width, height);
        }

        @Override
        protected char[] alphas() {
            // 生成随机数字和运算符
            int n1 = num(1, 10), n2 = num(1, 10);
            int opt = num(3);

            // 计算结果
            int res = new int[]{n1 + n2, n1 - n2, n1 * n2}[opt];
            // 转换为字符运算符
            char optChar = "+-x".charAt(opt);

            this.setArithmeticString(String.format("%s%c%s=?", n1, optChar, n2));
            this.chars = String.valueOf(res);

            return chars.toCharArray();
        }
    }
}
