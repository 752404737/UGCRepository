package com.chinaunicom.management.config;

import com.chinaunicom.management.constant.CommonConstant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *@MapperScan扫描包com.chinaunicom.${com.chinaunicom.projectname}.orm.mapper下的所有接口作为Mapper， 这样就不需要在每个接口上配置@Mapper注解了。
 */
@Configuration
@MapperScan(value = "com.chinaunicom." + CommonConstant.PROJECT_NAME +".orm.mapper")
public class MybatisConfig {
}