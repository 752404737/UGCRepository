package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.Usr;
import com.chinaunicom.management.entity.dto.UsrID;

import java.util.List;

public interface UsrMapper {
    int deleteByPrimaryKey(String usrAccount);

    int insert(Usr record);

    int insertSelective(Usr record);

    // 根据usrAccount获取用户对象
    Usr selectByPrimaryKey(String usrAccount);

    int updateByPrimaryKeySelective(Usr record);

    int updateByPrimaryKey(Usr record);

    List<UsrID> getUser();
}