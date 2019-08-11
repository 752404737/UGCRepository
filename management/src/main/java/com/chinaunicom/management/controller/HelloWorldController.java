package com.chinaunicom.management.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.management.entity.HelloWorld;
import com.chinaunicom.management.orm.HelloWorldDao;
import com.chinaunicom.management.util.HttpUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {
    private static Logger logger = LogManager.getLogger(HelloWorldController.class);

    @Autowired
    private HelloWorldDao helloWorldDao;

    @GetMapping("/helloWorldString")
    public String helloWorldString() {
        return "Hello World";
    }

    @GetMapping("/helloWorldModelAndView")
    public ModelAndView helloWorldModelAndView() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("HelloWorld", new HelloWorld());
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/helloWorldFastJson")
    public HelloWorld helloWorldFastJson() {
        return new HelloWorld(1, "HelloWorld");
    }

    @GetMapping("/helloWorldFastJsonObject")
    public void helloWorldFastJsonObject(HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("message", "HelloWorld");
        HttpUtils.printJsonToResponse(response, result);
    }

    @GetMapping("/helloWorldDao")
    public List<HelloWorld> helloWorldDao() {
        return helloWorldDao.getHelloWorld();
    }

    @GetMapping("/helloWorldValidation")
    public void helloWorldValidation(HttpServletResponse response, @Validated HelloWorld helloWorld, BindingResult bindingResult) {
        List<String> errors = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            for(ObjectError error : objectErrors) {
                errors.add(error.getDefaultMessage());
            }
            HttpUtils.printJsonToResponse(response, JSONArray.toJSONString(errors));
            return;
        }
        JSONObject result = new JSONObject();
        result.put("message", "success");
        HttpUtils.printJsonToResponse(response, result);
    }

    @GetMapping("/helloWorldLog4j2")
    public void helloWorldLog4j2(HttpServletResponse response) {
        logger.info("HelloWorld");
        JSONObject result = new JSONObject();
        result.put("message", "success");
        HttpUtils.printJsonToResponse(response, result);
    }

    @GetMapping("/indexHello")
    public ModelAndView indexHello() {
        return new ModelAndView("index");
    }

    @RequiresRoles("admin")
    @PostMapping("/helloAdmin")
    public String helloAdmin() {
        return "admin";
    }
}
