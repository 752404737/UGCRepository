package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ForumComment;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-8 下午6:12
 */
public interface ForumCommentDao {
    int insertSelective(ForumComment record);
    List<ForumComment> getForumCommentByForumAnswerId(Integer forumAnswerId);
    List<ForumComment> getForumCommentForPage(Integer forumAnswerId, Integer currentIndex, Integer pageSize);
}
