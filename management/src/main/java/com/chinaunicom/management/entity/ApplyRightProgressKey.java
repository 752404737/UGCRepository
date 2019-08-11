package com.chinaunicom.management.entity;

public class ApplyRightProgressKey {
    private String usrAccount;

    private String applyRoleId;

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount == null ? null : usrAccount.trim();
    }

    public String getApplyRoleId() {
        return applyRoleId;
    }

    public void setApplyRoleId(String applyRoleId) {
        this.applyRoleId = applyRoleId == null ? null : applyRoleId.trim();
    }
}