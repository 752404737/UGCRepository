package com.chinaunicom.management.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-4 下午2:34
 */
@RestController
public class UsrController {
    /**
     * @param usrName
     * @param passWord
     * @return
     */
    @PostMapping("/doLogin")
    public ModelAndView doLogin(String usrName, String passWord) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token令牌
        UsernamePasswordToken token = new UsernamePasswordToken(usrName, passWord);

        ModelAndView mv = new ModelAndView();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            mv.addObject("msg", "未知账户!");
            mv.setViewName("login");
            return mv;
        } catch (AuthenticationException e) {
            mv.addObject("msg", "用户名或者密码不正确!");
            mv.setViewName("login");
            return mv;
        }
        if (subject.isAuthenticated()) {
            mv.addObject("msg", "登录成功!");
            mv.setViewName("index");
        } else {
            mv.addObject("msg", "登录失败!");
            mv.setViewName("index");
        }
        return mv;
    }
}
