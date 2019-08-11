package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.Role;
import com.chinaunicom.management.orm.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-9 下午1:28
 */
@Service
public class RoleDaoImpl implements RoleDao {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public Role selectByPrimaryKey(String roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
