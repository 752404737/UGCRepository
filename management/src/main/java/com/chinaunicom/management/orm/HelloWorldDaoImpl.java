package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.HelloWorld;
import com.chinaunicom.management.orm.mapper.HelloWorldMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HelloWorldDaoImpl implements HelloWorldDao {
    @Resource
    private HelloWorldMapper helloWorldMapper;
    @Override
    public List<HelloWorld> getHelloWorld() {
        return helloWorldMapper.getHelloWorld();
    }
}
