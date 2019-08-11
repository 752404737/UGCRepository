package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ForumComment;
import com.chinaunicom.management.orm.mapper.ForumCommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-8 下午6:13
 */
@Service
public class ForumCommentDaoImpl implements ForumCommentDao {
    @Resource
    private ForumCommentMapper forumCommentMapper;

    @Override
    public int insertSelective(ForumComment record) {
        return forumCommentMapper.insertSelective(record);
    }

    @Override
    public List<ForumComment> getForumCommentByForumAnswerId(Integer forumAnswerId) {
        return forumCommentMapper.getForumCommentByForumAnswerId(forumAnswerId);
    }

    @Override
    public List<ForumComment> getForumCommentForPage(Integer forumAnswerId, Integer currentIndex, Integer pageSize) {
        return forumCommentMapper.getForumCommentForPage(forumAnswerId, currentIndex, pageSize);
    }
}
