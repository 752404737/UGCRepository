package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.Func;
import com.chinaunicom.management.entity.FuncKey;

public interface FuncMapper {
    int deleteByPrimaryKey(FuncKey key);

    int insert(Func record);

    int insertSelective(Func record);

    Func selectByPrimaryKey(FuncKey key);

    int updateByPrimaryKeySelective(Func record);

    int updateByPrimaryKey(Func record);
}