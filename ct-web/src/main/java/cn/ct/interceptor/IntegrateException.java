package cn.ct.interceptor;

import cn.ct.exception.ReturnViewException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ct.team
 * @Description 全局异常处理
 * Version 1.0
 */
@Component
public class IntegrateException implements HandlerExceptionResolver{

    private Logger logger = LoggerFactory.getLogger(IntegrateException.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        logger.info("[resolveException]：全局异常处理");
        ReturnViewException returnViewException = null;
        //如果抛出的异常类型是我们预想的，会想前台返回我们指定在参数里的页面
        if (ex instanceof ReturnViewException) {
            returnViewException = (ReturnViewException) ex;
        } else {
            //这里的500是我资源下的500.jsp，使用了mvc的映射省去了前缀后缀
            //系统默认跳转到500页面
            returnViewException = new ReturnViewException("500");
        }
        logger.error("e.getMessage：" + ex.getMessage());
        ex.printStackTrace();
        ModelAndView model = new ModelAndView();
        model.setViewName(returnViewException.getMessage());
        return model;
    }
}
