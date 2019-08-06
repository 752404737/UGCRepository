package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.Usr;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午6:05
 */
public interface UsrDao {
    // 根据usrAccount获取用户对象
    Usr selectByPrimaryKey(String usrAccount);
}
