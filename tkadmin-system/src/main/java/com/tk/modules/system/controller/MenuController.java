package com.tk.modules.system.controller;

import com.tk.config.jwt.JwtToken;
import com.tk.modules.system.entity.Menu;
import com.tk.modules.system.service.IMenuService;
import com.tk.modules.system.vo.MenuVo;
import com.tk.utils.response.Responder;
import com.tk.utils.response.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : MenuController
 * @description : [菜单相关控制器]
 * @createTime : [2022/1/24 11:31]
 * @updateUser : [Zara-cat]
 * @updateTime : [2022/1/24 11:31]
 * @updateRemark : [描述说明本次修改内容]
 */
@RestController
@Api(tags = "系统：菜单相关业务接口")
@RequestMapping("/api/menus")
public class MenuController {
    private final IMenuService iMenuService;

    public MenuController(IMenuService iMenuService) {
        this.iMenuService = iMenuService;
    }

    @GetMapping("/build")
    @ApiOperation("获取前端所需菜单")
    public ResultDTO<Object> buildMenus(){
        // 根据 security JwtRealm 拦截的 token 信息 解析出当前用户名
        JwtToken principal = (JwtToken) SecurityUtils.getSubject().getPrincipal();
        List<MenuVo> menusByUser = iMenuService.findMenusByUser(principal.getPrincipal().toString());
        return Responder.successful(menusByUser);
    }
}
