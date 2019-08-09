package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.ForumComment;

import java.util.List;

public interface ForumCommentMapper {
    List<ForumComment> getForumCommentByForumAnswerId(Integer forumAnswerId);

    List<ForumComment> getForumCommentForPage(Integer forumAnswerId, Integer currentIndex, Integer pageSize);

    int deleteByPrimaryKey(Integer forumCommentId);

    int insert(ForumComment record);

    int insertSelective(ForumComment record);

    ForumComment selectByPrimaryKey(Integer forumCommentId);

    int updateByPrimaryKeySelective(ForumComment record);

    int updateByPrimaryKey(ForumComment record);
}