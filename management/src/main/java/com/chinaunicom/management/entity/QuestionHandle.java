package com.chinaunicom.management.entity;

import java.util.Date;

public class QuestionHandle {
    int id;
    String usr_account;
    String content;
    String question;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
