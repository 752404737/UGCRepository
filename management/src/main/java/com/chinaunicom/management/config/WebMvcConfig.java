package com.chinaunicom.management.config;

import com.chinaunicom.management.interceptor.HelloWorldInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * addPathPatterns表示拦截路径
     * excludePathPatterns表示排除的路径
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HelloWorldInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/helloWorldString");
    }

    /**
     * 配置不需要角色就能访问的接口
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/unauthorized").setViewName("unauthorized");
    }
}
