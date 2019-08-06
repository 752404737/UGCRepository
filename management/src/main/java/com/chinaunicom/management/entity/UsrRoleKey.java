package com.chinaunicom.management.entity;

public class UsrRoleKey {
    private String usrAccount;

    private String roleId;

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount == null ? null : usrAccount.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}