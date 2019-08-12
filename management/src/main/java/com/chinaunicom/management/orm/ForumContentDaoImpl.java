package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ForumContent;
import com.chinaunicom.management.entity.dto.PageQueryParam;
import com.chinaunicom.management.orm.mapper.ForumContentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-7 下午8:44
 */
@Service
public class ForumContentDaoImpl implements ForumContentDao {
    @Resource
    private ForumContentMapper forumContentMapper;

    @Override
    public List<ForumContent> selectAllForumContent() {
        return forumContentMapper.selectAllForumContent();
    }

    @Override
    public List<ForumContent> selectForumContentForPage(PageQueryParam pageQueryParam) {
        return forumContentMapper.selectForumContentForPage(pageQueryParam);
    }

    @Override
    public ForumContent selectByPrimaryKey(Integer forumContentId) {
        return forumContentMapper.selectByPrimaryKey(forumContentId);
    }

    @Override
    public int getForumContentCountByUsrAccount(String usrAccount) {
        return forumContentMapper.getForumContentCountByUsrAccount(usrAccount);
    }

    @Override
    public int insertSelective(ForumContent record) {
        return forumContentMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(ForumContent record) {
        return forumContentMapper.updateByPrimaryKeySelective(record);
    }
}
