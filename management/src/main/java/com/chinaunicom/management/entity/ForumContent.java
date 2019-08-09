package com.chinaunicom.management.entity;

import java.util.Date;

public class ForumContent {
    private Integer forumContentId;

    private String forumContentTitle;

    private String usrAccount;

    private Integer answerCount;

    private Integer viewCount;

    private String linkTaskId;

    private Date createTime;

    private String forumContent;

    private Usr usr;

    public Integer getForumContentId() {
        return forumContentId;
    }

    public void setForumContentId(Integer forumContentId) {
        this.forumContentId = forumContentId;
    }

    public String getForumContentTitle() {
        return forumContentTitle;
    }

    public void setForumContentTitle(String forumContentTitle) {
        this.forumContentTitle = forumContentTitle == null ? null : forumContentTitle.trim();
    }

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount == null ? null : usrAccount.trim();
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getLinkTaskId() {
        return linkTaskId;
    }

    public void setLinkTaskId(String linkTaskId) {
        this.linkTaskId = linkTaskId == null ? null : linkTaskId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent == null ? null : forumContent.trim();
    }

    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }
}