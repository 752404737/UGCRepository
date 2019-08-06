package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.RolePrivilegeKey;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午5:38
 */
public interface RolePrivilegeDao {
    // 根据roleIdList 获取 privilegeId
    List<RolePrivilegeKey> selectPrivilegeIdByRoleIdList(List<String> roleIdList);
}
