package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.UsrRoleKey;
import com.chinaunicom.management.orm.mapper.UsrRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午4:13
 */
@Service
public class UsrRoleDaoImpl implements UsrRoleDao {

    @Resource
    private UsrRoleMapper usrRoleMapper;

    @Override
    public List<UsrRoleKey> getRoleIdByUsrAccount(String usrAccount) {
        return usrRoleMapper.getRoleIdByUsrAccount(usrAccount);
    }
}
