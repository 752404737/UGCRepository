package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.ForumContent;
import com.chinaunicom.management.entity.dto.PageQueryParam;

import java.util.List;

public interface ForumContentMapper {

    /**
     * @return 返回论坛所有内容
     */
    List<ForumContent> selectAllForumContent();

    /**
     * @param pageQueryParam 分页查询参数包括当前页码、每页显示的数量
     * @return 分页查询结果的论坛内容
     */
    List<ForumContent> selectForumContentForPage(PageQueryParam pageQueryParam);

    int deleteByPrimaryKey(Integer forumContentId);

    int insert(ForumContent record);

    /**
     * 选择不插入null值
     * @param record
     * @return 返回插入的条数
     */
    int insertSelective(ForumContent record);

    /**
     * @param forumContentId
     * @return 根据主键Id获取 论坛内容
     */
    ForumContent selectByPrimaryKey(Integer forumContentId);

    int updateByPrimaryKeySelective(ForumContent record);

    int updateByPrimaryKeyWithBLOBs(ForumContent record);

    int updateByPrimaryKey(ForumContent record);
}