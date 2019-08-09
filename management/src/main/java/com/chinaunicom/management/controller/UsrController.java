package com.chinaunicom.management.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.management.entity.Usr;
import com.chinaunicom.management.entity.dto.UsrID;
import com.chinaunicom.management.orm.UsrDao;
import com.chinaunicom.management.entity.Usr;
import com.chinaunicom.management.orm.UsrDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-4 下午2:34
 */
@RestController
public class UsrController {

    @Autowired
    private UsrDao usrDao;

    /**
     * @param usrName
     * @param passWord
     * @return
     */

    @Autowired
    private UsrDao usrDao;

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

    //站内用户数量统计
    @PostMapping("/userSortNum")
    public JSONObject userSortNum() {
        int pm = 0;
        int rd = 0;
        int test = 0;
        int admin = 0;
        JSONObject jsonObject = new JSONObject();
        List list = usrDao.getUser();
        for (int i = 0; i < list.size(); i++) {
            UsrID usr = (UsrID) list.get(i);
            String id = usr.getRole_id();
            if (id.contains("pm")) {
                pm++;
            }
            if (id.contains("rd")) {
                rd++;
            }
            if (id.contains("test")) {
                test++;
            }
            if (id.contains("admin")) {
                admin++;
            }
        }
        jsonObject.put("产品经理", pm);
        jsonObject.put("研发", rd);
        jsonObject.put("测试", test);
        jsonObject.put("管理员", admin);
        return jsonObject;
    }


    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @PostMapping("/getUsrByUsrAccount")
    public Usr getUsrByUsrAccount(String usrAccount) {
        return usrDao.selectByPrimaryKey(usrAccount);
    }
}
