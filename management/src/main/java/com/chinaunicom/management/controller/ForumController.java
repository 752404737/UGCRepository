package com.chinaunicom.management.controller;

import com.chinaunicom.management.entity.ForumAnswer;
import com.chinaunicom.management.entity.ForumComment;
import com.chinaunicom.management.entity.ForumContent;
import com.chinaunicom.management.entity.Usr;
import com.chinaunicom.management.entity.dto.PageQueryParam;
import com.chinaunicom.management.orm.ForumAnswerDao;
import com.chinaunicom.management.orm.ForumCommentDao;
import com.chinaunicom.management.orm.ForumContentDao;
import com.chinaunicom.management.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-7 下午8:24
 */
@RestController
public class ForumController {
    @Autowired
    private ForumContentDao forumContentDao;

    @Autowired
    private ForumAnswerDao forumAnswerDao;

    @Autowired
    private ForumCommentDao forumCommentDao;

    /**
     * 保存提问
     * @param forumContentTitle
     * @param forumContent
     * @param linkTaskId
     * @return
     */
    @PostMapping("/saveForumContent")
    public ForumContent saveForumContent(String forumContentTitle, String forumContent, String linkTaskId) {
        ForumContent fc = new ForumContent();
        fc.setForumContentTitle(forumContentTitle);
        fc.setForumContent(forumContent);
        fc.setLinkTaskId(linkTaskId);
        fc.setCreateTime(new Date());
        fc.setAnswerCount(0);
        fc.setViewCount(0);
        Usr usr = SessionUtils.getUsrFromSession();
        fc.setUsrAccount(usr.getUsrAccount());
        // 根据mybatis中的xml配置, 返回的主键值是直接设置在fc.forumContentId中
        forumContentDao.insertSelective(fc);
        fc.setUsr(usr);
        return fc;
    }

    /**
     * 获取所有的论坛提问内容
     */
    @PostMapping("/getAllForumContent")
    public List<ForumContent> getAllForumContent() {
        List<ForumContent> forumContentList = forumContentDao.selectAllForumContent();
        return forumContentList;
    }

    /**
     * 分页查询论坛内容
     * @param pageQueryParam
     * @return
     */
    @PostMapping("/getForumContentForPage")
    public List<ForumContent> getForumContentForPage(@Validated PageQueryParam pageQueryParam) {
        List<ForumContent> forumContentList = forumContentDao.selectForumContentForPage(pageQueryParam);
        return forumContentList;
    }

    /**
     * @param forumContentId
     * @return 返回论坛Id对应的论坛内容
     */
    @PostMapping("/getForumContentById")
    public ForumContent getForumContentById(Integer forumContentId) {
        return forumContentDao.selectByPrimaryKey(forumContentId);
    }

    /**
     * 保存论坛回答
     * @param forumContentId
     * @param answerContent
     * @return
     */
    @PostMapping("/saveForumAnswer")
    public ForumAnswer saveForumAnswer(Integer forumContentId, String answerContent) {
        Usr usr = SessionUtils.getUsrFromSession();
        ForumAnswer forumAnswer = new ForumAnswer();
        forumAnswer.setForumContentId(forumContentId);
        forumAnswer.setUsrAccount(usr.getUsrAccount());
        forumAnswer.setAnswerContent(answerContent);
        forumAnswer.setLikeCount(0);
        forumAnswer.setCreateTime(new Date());
        forumAnswerDao.insertSelective(forumAnswer);
        forumAnswer.setUsr(usr);

        // 更新回答问题数
        ForumContent forumContent = forumContentDao.selectByPrimaryKey(forumContentId);
        Integer answerCount = forumContent.getAnswerCount() + 1;
        forumContent.setAnswerCount(answerCount);
        forumContentDao.updateByPrimaryKeySelective(forumContent);

        return forumAnswer;
    }

    /**
     * 添加浏览数量
     * @param forumContentId
     * @return
     */
    @PostMapping("/addForumContentViewCount")
    public ForumContent addForumContentViewCount(Integer forumContentId) {
        // 更新回答问题数
        ForumContent forumContent = forumContentDao.selectByPrimaryKey(forumContentId);
        Integer viewCount = forumContent.getViewCount() + 1;
        forumContent.setViewCount(viewCount);
        forumContentDao.updateByPrimaryKeySelective(forumContent);
        return forumContent;
    }

    /**
     * @param forumContentId
     * @return 论坛提问对应的回答
     */
    @PostMapping("/getForumAnswerByForumContentId")
    public List<ForumAnswer> getForumAnswerByForumContentId(Integer forumContentId) {
        return forumAnswerDao.getForumAnswerByForumContentId(forumContentId);
    }

    /**
     * @param forumContentId
     * @return 论坛提问对应的回答
     */
    @PostMapping("/getForumAnswerForPage")
    public List<ForumAnswer> getForumAnswerForPage(Integer forumContentId, @Validated PageQueryParam pageQueryParam) {
        List<ForumAnswer> forumAnswerList = forumAnswerDao.selectForumAnswerForPage(forumContentId, pageQueryParam.getCurrentIndex(), pageQueryParam.getPageSize());
        return forumAnswerList;
    }

    /**
     * 点赞
     * @param forumAnswerId
     * @return
     */
    @PostMapping("/addForumAnswerLikeCount")
    public ForumAnswer addForumAnswerLikeCount(Integer forumAnswerId) {
        ForumAnswer forumAnswer = forumAnswerDao.selectByPrimaryKey(forumAnswerId);
        if (forumAnswer == null) return null;
        Integer likeCount = forumAnswer.getLikeCount() + 1;
        forumAnswer.setLikeCount(likeCount);
        forumAnswerDao.updateByPrimaryKeySelective(forumAnswer);
        return forumAnswer;
    }

    /**
     * 保存用户对回答的评论
     * @param forumAnswerId
     * @param forumComment
     * @return
     */
    @PostMapping("/saveForumComment")
    public ForumComment saveForumComment(Integer forumAnswerId, String forumComment) {
        Usr usr = SessionUtils.getUsrFromSession();
        ForumComment fc = new ForumComment();
        fc.setForumAnswerId(forumAnswerId);
        fc.setUsrAccount(usr.getUsrAccount());
        fc.setForumComment(forumComment);
        fc.setCreateTime(new Date());
        forumCommentDao.insertSelective(fc);
        fc.setUsr(usr);

        // 更新评论数量
        ForumAnswer forumAnswer = forumAnswerDao.selectByPrimaryKey(forumAnswerId);
        Integer answerCount = forumAnswer.getAnswerCount() + 1;
        forumAnswer.setAnswerCount(answerCount);
        forumAnswerDao.updateByPrimaryKeySelective(forumAnswer);

        return fc;
    }

    /**
     * 返回对问题回答的评论
     * @param forumAnswerId
     * @return
     */
    @PostMapping("/getForumCommentByForumAnswerId")
    public List<ForumComment> getForumCommentByForumAnswerId(Integer forumAnswerId) {
        List<ForumComment> forumCommentList = forumCommentDao.getForumCommentByForumAnswerId(forumAnswerId);
        return forumCommentList;
    }

    /**
     * 返回对问题回答的评论,分页查询
     * @param forumAnswerId
     * @param pageQueryParam
     * @return
     */
    @PostMapping("/getForumCommentForPage")
    public List<ForumComment> getForumCommentForPage(Integer forumAnswerId, @Validated PageQueryParam pageQueryParam) {
        List<ForumComment> forumCommentList = forumCommentDao.getForumCommentForPage(forumAnswerId, pageQueryParam.getCurrentIndex(), pageQueryParam.getPageSize());
        return forumCommentList;
    }

}
