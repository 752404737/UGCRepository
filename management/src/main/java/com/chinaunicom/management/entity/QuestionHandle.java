package com.chinaunicom.management.entity;

import java.util.Date;

public class QuestionHandle {
    int id;
    String usr_account;
    String type;
    String questionid;
    Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr_account() {
        return usr_account;
    }

    public void setUsr_account(String usr_account) {
        this.usr_account = usr_account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
