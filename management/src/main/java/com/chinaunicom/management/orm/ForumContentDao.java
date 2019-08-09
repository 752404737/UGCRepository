package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ForumContent;
import com.chinaunicom.management.entity.dto.PageQueryParam;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-7 下午8:44
 */
public interface ForumContentDao {
    /**
     * @return 返回论坛所有内容
     */
    List<ForumContent> selectAllForumContent();

    /**
     * @param pageQueryParam 分页查询参数包括当前页码、每页显示的数量
     * @return 分页查询结果的论坛内容
     */
    List<ForumContent> selectForumContentForPage(PageQueryParam pageQueryParam);

    /**
     * @param forumContentId
     * @return 根据主键Id获取 论坛内容
     */
    ForumContent selectByPrimaryKey(Integer forumContentId);

    int insertSelective(ForumContent record);

    int updateByPrimaryKeySelective(ForumContent record);
}
