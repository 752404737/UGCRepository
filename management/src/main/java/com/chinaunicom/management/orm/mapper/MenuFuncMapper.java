package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.MenuFuncKey;

public interface MenuFuncMapper {
    int deleteByPrimaryKey(MenuFuncKey key);

    int insert(MenuFuncKey record);

    int insertSelective(MenuFuncKey record);
}