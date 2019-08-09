package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.Usr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsrMapper {
    int deleteByPrimaryKey(String usrAccount);

    int insert(Usr record);

    int insertSelective(Usr record);

    // 根据usrAccount获取用户对象
    Usr selectByPrimaryKey(String usrAccount);

    // 批量查询用户
    List<Usr> selectByPrimaryKeyList(@Param("usrAccountList") List<String> usrAccountList);

    int updateByPrimaryKeySelective(Usr record);

    int updateByPrimaryKey(Usr record);
}