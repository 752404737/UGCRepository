package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.Role;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-9 下午1:28
 */
public interface RoleDao {
    /**
     * 获取所有角色
     * @return
     */
    List<Role> getAllRole();

    Role selectByPrimaryKey(String roleId);
}
