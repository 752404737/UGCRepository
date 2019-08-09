package com.chinaunicom.management.entity;

import java.util.Date;

public class ForumAnswer {
    private Integer forumAnswerId;

    private Integer forumContentId;

    private String usrAccount;

    private Integer answerCount;

    private Integer likeCount;

    private Date createTime;

    private String answerContent;

    private Usr usr;

    public Integer getForumAnswerId() {
        return forumAnswerId;
    }

    public void setForumAnswerId(Integer forumAnswerId) {
        this.forumAnswerId = forumAnswerId;
    }

    public Integer getForumContentId() {
        return forumContentId;
    }

    public void setForumContentId(Integer forumContentId) {
        this.forumContentId = forumContentId;
    }

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount == null ? null : usrAccount.trim();
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }
}