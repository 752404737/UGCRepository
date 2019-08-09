package com.chinaunicom.management.entity;

import java.util.Date;

public class ForumComment {
    private Integer forumCommentId;

    private Integer forumAnswerId;

    private String usrAccount;

    private String forumComment;

    private Date createTime;

    private Usr usr;

    public Integer getForumCommentId() {
        return forumCommentId;
    }

    public void setForumCommentId(Integer forumCommentId) {
        this.forumCommentId = forumCommentId;
    }

    public Integer getForumAnswerId() {
        return forumAnswerId;
    }

    public void setForumAnswerId(Integer forumAnswerId) {
        this.forumAnswerId = forumAnswerId;
    }

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount == null ? null : usrAccount.trim();
    }

    public String getForumComment() {
        return forumComment;
    }

    public void setForumComment(String forumComment) {
        this.forumComment = forumComment == null ? null : forumComment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }
}