package com.chinaunicom.management.util;

import com.chinaunicom.management.entity.Usr;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-1 上午8:24
 */
public class SessionUtils {
    /**
     *
     * @param request HttpServletRequest, 在Controller中直接作为方法参数获取methodName(HttpServletRequest request)
     * @return HttpSession 用户会话
     */
    public static HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session;
    }

    /**
     * @return 获取用户信息
     */
    public static Usr getUsrFromSession() {
        Subject subject = SecurityUtils.getSubject();
        Usr usr = (Usr)subject.getPrincipal();
        return usr;
    }
}
