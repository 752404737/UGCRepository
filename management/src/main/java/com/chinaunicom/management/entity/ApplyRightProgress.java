package com.chinaunicom.management.entity;

import java.util.Date;

public class ApplyRightProgress extends ApplyRightProgressKey {
    private String applyRoleName;

    private String applyUsrAccount;

    private String applyUsrName;

    private String applyStateName;

    private Integer applyState;

    private Date createTime;

    public String getApplyRoleName() {
        return applyRoleName;
    }

    public void setApplyRoleName(String applyRoleName) {
        this.applyRoleName = applyRoleName == null ? null : applyRoleName.trim();
    }

    public String getApplyUsrAccount() {
        return applyUsrAccount;
    }

    public void setApplyUsrAccount(String applyUsrAccount) {
        this.applyUsrAccount = applyUsrAccount == null ? null : applyUsrAccount.trim();
    }

    public String getApplyUsrName() {
        return applyUsrName;
    }

    public void setApplyUsrName(String applyUsrName) {
        this.applyUsrName = applyUsrName == null ? null : applyUsrName.trim();
    }

    public String getApplyStateName() {
        return applyStateName;
    }

    public void setApplyStateName(String applyStateName) {
        this.applyStateName = applyStateName == null ? null : applyStateName.trim();
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}