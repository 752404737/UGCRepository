package com.chinaunicom.management.entity;

public class Usr {
    private String usrAccount;

    private String usrName;

    private String usrPassword;

    private String usrHeadportraitUrl;

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount == null ? null : usrAccount.trim();
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName == null ? null : usrName.trim();
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword == null ? null : usrPassword.trim();
    }

    public String getUsrHeadportraitUrl() {
        return usrHeadportraitUrl;
    }

    public void setUsrHeadportraitUrl(String usrHeadportraitUrl) {
        this.usrHeadportraitUrl = usrHeadportraitUrl == null ? null : usrHeadportraitUrl.trim();
    }
}