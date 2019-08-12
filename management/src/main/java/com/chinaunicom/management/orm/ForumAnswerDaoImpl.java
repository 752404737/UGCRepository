package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ForumAnswer;
import com.chinaunicom.management.orm.mapper.ForumAnswerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-8 下午2:43
 */
@Service
public class ForumAnswerDaoImpl implements ForumAnswerDao {

    @Resource
    private ForumAnswerMapper forumAnswerMapper;

    @Override
    public int insertSelective(ForumAnswer record) {
        return forumAnswerMapper.insertSelective(record);
    }

    @Override
    public List<ForumAnswer> getForumAnswerByForumContentId(Integer forumContentId) {
        return forumAnswerMapper.getForumAnswerByForumContentId(forumContentId);
    }

    @Override
    public List<ForumAnswer> selectForumAnswerForPage(Integer forumContentId, Integer currentIndex, Integer pageSize) {
        return forumAnswerMapper.selectForumAnswerForPage(forumContentId, currentIndex, pageSize);
    }

    @Override
    public int getLikeCountByUsrAccount(String usrAccount) {
        return forumAnswerMapper.getLikeCountByUsrAccount(usrAccount);
    }

    @Override
    public ForumAnswer selectByPrimaryKey(Integer forumAnswerId) {
        return forumAnswerMapper.selectByPrimaryKey(forumAnswerId);
    }

    @Override
    public int updateByPrimaryKeySelective(ForumAnswer record) {
        return forumAnswerMapper.updateByPrimaryKeySelective(record);
    }
}
