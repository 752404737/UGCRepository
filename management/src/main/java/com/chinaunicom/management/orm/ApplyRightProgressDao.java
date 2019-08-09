package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ApplyRightProgress;
import com.chinaunicom.management.entity.ApplyRightProgressKey;

import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-9 下午4:22
 */
public interface ApplyRightProgressDao {
    int insertSelective(ApplyRightProgress record);

    List<ApplyRightProgress> getApplyRightProgressByUsrAccount(String usrAccount);

    List<ApplyRightProgress> getApplyRightProgressByUsrAccountForPage(String usrAccount, Integer currentIndex, Integer pageSize);

    List<ApplyRightProgress> getApplyRightProgressByState(String usrAccount, Integer currentIndex, Integer pageSize, Integer applyState);

    ApplyRightProgress selectByPrimaryKey(ApplyRightProgressKey key);

    int updateByPrimaryKeySelective(ApplyRightProgress record);
}
