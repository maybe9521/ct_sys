package cn.ct.interceptor;

import cn.ct.common.util.Constants;
import cn.ct.model.dto.SysUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ct.team
 * @Description 登录验证
 * Version 1.0
 */
@Component
public class SysInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(SysInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("[preHandle]：登录验证");

        HttpSession session = request.getSession();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.USER_SESSION);
        if(sysUser == null){
            response.sendRedirect(request.getContextPath()+"/403.jsp");
            return false;
        }
        return true;
    }
}