package com.chinaunicom.management.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-4 下午2:49
 *
 * 配置全局异常处理
 */
@ControllerAdvice
public class ExceptionConfig {
    /**
     * 在用户访问未授权资源时，跳转到unauthorized视图中，并携带出错信息
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public ModelAndView error(AuthenticationException e) {
        ModelAndView mv = new ModelAndView("unauthorized");
        mv.addObject("error", e.getMessage());
        return mv;
    }
}
