package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.RolePrivilegeKey;
import com.chinaunicom.management.orm.mapper.RolePrivilegeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午5:41
 */
@Service
public class RolePrivilegeDaoImpl implements RolePrivilegeDao {
    @Resource
    private RolePrivilegeMapper rolePrivilegeDaoMapper;

    @Override
    public List<RolePrivilegeKey> selectPrivilegeIdByRoleIdList(List<String> roleIdList) {
        return rolePrivilegeDaoMapper.selectPrivilegeIdByRoleIdList(roleIdList);
    }
}
