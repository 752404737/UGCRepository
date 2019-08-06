package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.Menu;
import com.chinaunicom.management.entity.MenuKey;

public interface MenuMapper {
    int deleteByPrimaryKey(MenuKey key);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(MenuKey key);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}