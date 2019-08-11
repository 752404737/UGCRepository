package com.chinaunicom.management.entity;

import java.util.Date;

public class QuestionComment {
    String usr_name;
    String usr_headportrait_url;
    Date date;
    String content;
    String question;

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getUsr_headportrait_url() {
        return usr_headportrait_url;
    }

    public void setUsr_headportrait_url(String usr_headportrait_url) {
        this.usr_headportrait_url = usr_headportrait_url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
