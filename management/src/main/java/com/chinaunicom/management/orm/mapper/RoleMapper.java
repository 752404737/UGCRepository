package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.Role;

import java.util.List;

public interface RoleMapper {

    /**
     * 获取所有角色
     * @return
     */
    List<Role> getAllRole();

    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}