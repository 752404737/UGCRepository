package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.UsrRoleKey;

import java.util.List;

public interface UsrRoleMapper {
    // 根据usrAccount获取roleId
    List<UsrRoleKey> getRoleIdByUsrAccount(String usrAccount);

    int deleteByPrimaryKey(UsrRoleKey key);

    int insert(UsrRoleKey record);

    int insertSelective(UsrRoleKey record);
}