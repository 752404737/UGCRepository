package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ForumAnswer;
import com.chinaunicom.management.entity.dto.PageQueryParam;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-8 下午2:43
 */
public interface ForumAnswerDao {
    /**
     * 添加对论坛提问的回答
     * @param record
     * @return 插入数据条数的数量
     */
    int insertSelective(ForumAnswer record);

    /**
     * 根据论坛提问的Id获取对应回答的内容
     * @param forumContentId
     * @return
     */
    List<ForumAnswer> getForumAnswerByForumContentId(Integer forumContentId);

    /**
     * 根据论坛提问的Id获取对应回答的内容, 做分页查询
     * @param forumContentId
     * @param currentIndex
     * @param pageSize
     * @return
     */
    List<ForumAnswer> selectForumAnswerForPage(Integer forumContentId, Integer currentIndex, Integer pageSize);

    ForumAnswer selectByPrimaryKey(Integer forumAnswerId);

    int updateByPrimaryKeySelective(ForumAnswer record);
}
