package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.ApplyRightProgress;
import com.chinaunicom.management.entity.ApplyRightProgressKey;

import java.util.List;

public interface ApplyRightProgressMapper {
    int deleteByPrimaryKey(ApplyRightProgressKey key);

    int insert(ApplyRightProgress record);

    int insertSelective(ApplyRightProgress record);

    ApplyRightProgress selectByPrimaryKey(ApplyRightProgressKey key);

    int updateByPrimaryKeySelective(ApplyRightProgress record);

    int updateByPrimaryKey(ApplyRightProgress record);

    List<ApplyRightProgress> getApplyRightProgressByUsrAccount(String usrAccount);

    /**
     * 获取向管理员申请权限的申请进程，usrAccount:登入的管理员账号
     * @param usrAccount 管理员账号
     * @return
     */
    List<ApplyRightProgress> getApplyRightProgressByApplyUsrAccount(String usrAccount);

    /**
     * 获取向管理员申请权限的申请进程，usrAccount:登入的管理员账号， 分页查询
     * @param usrAccount 管理员账号
     * @return
     */
    List<ApplyRightProgress> getApplyRightProgressByApplyUsrAccountForPage(String usrAccount, Integer currentIndex, Integer pageSize);

    List<ApplyRightProgress> getApplyRightProgressByUsrAccountForPage(String usrAccount, Integer currentIndex, Integer pageSize);

    List<ApplyRightProgress> getApplyRightProgressByState(String usrAccount, Integer currentIndex, Integer pageSize, Integer applyState);
}