package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.Usr;
import com.chinaunicom.management.orm.mapper.UsrMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午6:06
 */
@Service
public class UsrDaoImpl implements UsrDao {
    @Resource
    private UsrMapper usrMapper;

    @Override
    public Usr selectByPrimaryKey(String usrAccount) {
        return usrMapper.selectByPrimaryKey(usrAccount);
    }

    @Override
    public List<Usr> selectByPrimaryKeyList(List<String> usrAccountList) {
        return usrMapper.selectByPrimaryKeyList(usrAccountList);
    }
}
