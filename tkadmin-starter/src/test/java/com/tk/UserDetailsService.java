package com.tk;

import com.tk.modules.security.service.IUserDetailsService;
import com.tk.modules.security.vo.LoadUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserDetailsService
 * @description : [描述说明该类的功能]
 * @createTime : [2022/1/26 23:24]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/26 23:24]
 * @updateRemark : [描述说明本次修改内容]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsService {
    @Autowired
    IUserDetailsService service;
    @Test
    public void setService(){
        LoadUserVo admin = service.loadUserByUserName("admin");
    }
}
