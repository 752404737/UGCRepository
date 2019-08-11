package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.ApplyRightProgress;
import com.chinaunicom.management.entity.ApplyRightProgressKey;
import com.chinaunicom.management.orm.mapper.ApplyRightProgressMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-9 下午4:23
 */
@Service
public class ApplyRightProgressDaoImpl implements ApplyRightProgressDao {
    @Resource
    private ApplyRightProgressMapper applyRightProgressMapper;

    @Override
    public int insertSelective(ApplyRightProgress record) {
        return applyRightProgressMapper.insertSelective(record);
    }

    @Override
    public List<ApplyRightProgress> getApplyRightProgressByUsrAccount(String usrAccount) {
        return applyRightProgressMapper.getApplyRightProgressByUsrAccount(usrAccount);
    }

    @Override
    public List<ApplyRightProgress> getApplyRightProgressByUsrAccountForPage(String usrAccount, Integer currentIndex, Integer pageSize) {
        return applyRightProgressMapper.getApplyRightProgressByUsrAccountForPage(usrAccount, currentIndex, pageSize);
    }

    @Override
    public List<ApplyRightProgress> getApplyRightProgressByState(String usrAccount, Integer currentIndex, Integer pageSize, Integer applyState) {
        return applyRightProgressMapper.getApplyRightProgressByState(usrAccount, currentIndex, pageSize, applyState);
    }

    @Override
    public ApplyRightProgress selectByPrimaryKey(ApplyRightProgressKey key) {
        return applyRightProgressMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(ApplyRightProgress record) {
        return applyRightProgressMapper.updateByPrimaryKeySelective(record);
    }


}
