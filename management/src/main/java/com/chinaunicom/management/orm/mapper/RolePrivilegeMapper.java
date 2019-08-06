package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.RolePrivilegeKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePrivilegeMapper {
    // 根据roleIdList 获取 privilegeId
    List<RolePrivilegeKey> selectPrivilegeIdByRoleIdList(@Param("roleIdList") List<String> roleIdList);

    int deleteByPrimaryKey(RolePrivilegeKey key);

    int insert(RolePrivilegeKey record);

    int insertSelective(RolePrivilegeKey record);
}