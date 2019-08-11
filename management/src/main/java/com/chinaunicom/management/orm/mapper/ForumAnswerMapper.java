package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.ForumAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForumAnswerMapper {
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

    int deleteByPrimaryKey(Integer forumAnswerId);

    int insert(ForumAnswer record);

    /**
     * 添加对论坛提问的回答
     * @param record
     * @return 插入数据条数的数量
     */
    int insertSelective(ForumAnswer record);

    ForumAnswer selectByPrimaryKey(Integer forumAnswerId);

    int updateByPrimaryKeySelective(ForumAnswer record);

    int updateByPrimaryKeyWithBLOBs(ForumAnswer record);

    int updateByPrimaryKey(ForumAnswer record);
}