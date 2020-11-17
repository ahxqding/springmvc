package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SystemExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 获取到异常对象
        SystemException e = null;
        if(ex instanceof SystemException) {
            e = (SystemException) ex;
        }else {
            e = new SystemException("系统正在维护。。。");
        }
        // 创建modelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
