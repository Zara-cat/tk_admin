package com.tk.modules.security.shiro.realm;


import com.tk.modules.security.entity.UserInfo;
import com.tk.modules.security.service.IAuthorizationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;


/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : DBRealm
 * @description : [subject 认证和授权]
 * @createTime : [2021/12/1 10:28]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/1 10:28]
 * @updateRemark : [描述说明本次修改内容]
 */
public class DBRealm extends AuthorizingRealm {

    @Autowired
    private IAuthorizationService iAuthorizationService;

    /**
     * 限定这个 Realm 只处理 UsernamePasswordToken
     *
     * @param token {@link UsernamePasswordToken}
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 查询数据库，将获取到的用户安全数据封装返回
        String username = authenticationToken.getPrincipal().toString();
        // 查询数据库获取用户信息。关于 service 对象 可以手动注入也可以依赖注入
        UserInfo userInfo = iAuthorizationService.getUserInfoByUserName(username);
        if (!ObjectUtils.isEmpty(userInfo)){
            if (userInfo.getEnabled() == 0){
                throw new LockedAccountException();
            }else {
                //构建vo 对象
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                        userInfo,
                        userInfo.getPassword(),
                        ByteSource.Util.bytes(userInfo.getSalt()),
                        this.getName()
                );
                return info;
            }
        }else {
            throw new UnknownAccountException();
        }
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入 DBRealm Authorization");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }


}
