package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.UsrRoleKey;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午4:12
 */
public interface UsrRoleDao {
    // 根据usrAccount获取roleId
    List<UsrRoleKey> getRoleIdByUsrAccount(String usrAccount);

    /**
     * 根据roleId获取usrAccount
     * @param roleId 角色Id
     * @return
     */
    List<UsrRoleKey> getUsrAccountByRoleId(String roleId);

    /**
     * 删除用户权限
     * @param key
     * @return
     */
    int deleteByPrimaryKey(UsrRoleKey key);
}
