package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.UsrRoleKey;

import java.util.List;

public interface UsrRoleMapper {
    // 根据usrAccount获取roleId
    List<UsrRoleKey> getRoleIdByUsrAccount(String usrAccount);

    /**
     * 根据roleId获取usrAccount
     * @param roleId 角色Id
     * @return
     */
    List<UsrRoleKey> getUsrAccountByRoleId(String roleId);

    int deleteByPrimaryKey(UsrRoleKey key);

    int insert(UsrRoleKey record);

    int insertSelective(UsrRoleKey record);
}