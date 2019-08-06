package com.chinaunicom.management.config;

import com.chinaunicom.management.component.UsrAuthRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.Resource;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-4 下午2:14
 */
@Configuration
public class ShiroConfig {

    @Resource
    private UsrAuthRealm usrAuthRealm;

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition =
                new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login", "anon");
        chainDefinition.addPathDefinition("/doLogin", "anon");
        chainDefinition.addPathDefinition("/logout", "logout");
        chainDefinition.addPathDefinition("/**", "anon");
        return chainDefinition;
    }

    /**
     * 配置 SecurityManager,可配置一个或多个realm
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(usrAuthRealm);
        return securityManager;
    }

    /**
     * 开启shiro 注解支持. 使以下注解能够生效 :
     * 需要认证 {@link org.apache.shiro.authz.annotation.RequiresAuthentication RequiresAuthentication}
     * 需要用户 {@link org.apache.shiro.authz.annotation.RequiresUser RequiresUser}
     * 需要访客 {@link org.apache.shiro.authz.annotation.RequiresGuest RequiresGuest}
     * 需要角色 {@link org.apache.shiro.authz.annotation.RequiresRoles RequiresRoles}
     * 需要权限 {@link org.apache.shiro.authz.annotation.RequiresPermissions RequiresPermissions}
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(this.securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
     * 在@Controller注解的类的方法中加入@RequiresRole等shiro注解，会导致该方法无法映射请求，
     * 导致返回404。加入这项配置能解决这个bug
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
