package cn.ct.controller;

import cn.ct.common.result.Result;
import cn.ct.common.util.Constants;
import cn.ct.model.dto.SysMenuDto;
import cn.ct.model.dto.SysRoleDto;
import cn.ct.model.dto.SysUserDto;
import cn.ct.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
@Controller
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping(value="/login")
    public String login2Html(){
        logger.info("[login2Html]：登录页面跳转");
        return "login";
    }
    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@RequestParam String account, @RequestParam String password,
                          HttpServletRequest request, HttpSession session) throws Exception {
        logger.info("[doLogin]：登录控制器");
        SysUserDto sysUser = authService.doLogin(account, password);
        // 登录成功
        if(sysUser != null){
            session.setAttribute(Constants.USER_SESSION,sysUser);
            return "redirect:/api/users/index";
        } else {
            request.setAttribute("error", "用户名或密码不正确");
            return "login";
        }
    }
    /**
     * 注销
     * @param session
     * @return
     */
    @RequestMapping(value="/api/auth/logout")
    public String logout(HttpSession session){
        logger.info("[logout]：注销");
        session.removeAttribute(Constants.USER_SESSION);
        return "login";
    }
    /**
     * 获取菜单列表
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/api/auth/getMenuList.json", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<SysMenuDto>> menuList(@RequestParam String userId) throws Exception {
        logger.info("[menuList]：获取菜单列表");
        return authService.getMenusList(Long.valueOf(userId));
    }
    /**
     * 获取角色列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/api/auth/getRoleList.json", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<SysRoleDto>> roleList() throws Exception {
        logger.info("[roleList]：获取角色列表");
        return authService.getRolesList();
    }
}
