package com.chinaunicom.management.entity;

public class Func extends FuncKey {
    private String funcName;

    private String funcEventName;

    private String funcIco;

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getFuncEventName() {
        return funcEventName;
    }

    public void setFuncEventName(String funcEventName) {
        this.funcEventName = funcEventName == null ? null : funcEventName.trim();
    }

    public String getFuncIco() {
        return funcIco;
    }

    public void setFuncIco(String funcIco) {
        this.funcIco = funcIco == null ? null : funcIco.trim();
    }
}