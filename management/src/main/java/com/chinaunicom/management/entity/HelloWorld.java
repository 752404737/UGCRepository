package com.chinaunicom.management.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HelloWorld {
    private Integer id;

    @NotNull(message = "{HelloWorld.helloWorld.notnull}")
    @Size(min = 5, max = 20, message = "{HelloWorld.helloWorld.size}")
    private String helloWorld;

    public HelloWorld() {
    }

    public HelloWorld(Integer id, String helloWorld) {
        this.id = id;
        this.helloWorld = helloWorld;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "id=" + id +
                ", helloWorld='" + helloWorld + '\'' +
                '}';
    }
}
