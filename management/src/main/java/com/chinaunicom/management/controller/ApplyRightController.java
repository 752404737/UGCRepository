package com.chinaunicom.management.controller;

import com.chinaunicom.management.entity.*;
import com.chinaunicom.management.entity.dto.PageQueryParam;
import com.chinaunicom.management.orm.ApplyRightProgressDao;
import com.chinaunicom.management.orm.RoleDao;
import com.chinaunicom.management.orm.UsrDao;
import com.chinaunicom.management.orm.UsrRoleDao;
import com.chinaunicom.management.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-9 下午1:12
 */
@RestController
public class ApplyRightController {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UsrRoleDao usrRoleDao;

    @Autowired
    private UsrDao usrDao;

    @Autowired
    private ApplyRightProgressDao applyRightProgressDao;

    /**
     * 获取所有角色信息
     * @return
     */
    @PostMapping("/getAllRole")
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    /**
     * 获取角色对应的所有用户
     * @param roleId
     * @return
     */
    @PostMapping("/getAllUsrByRoleId")
    public List<Usr> getAllManager(String roleId) {
        // 获取用户账户
        List<UsrRoleKey> usrRoleKeyList = usrRoleDao.getUsrAccountByRoleId(roleId);
        List<String> usrAccountList = new ArrayList<>();
        for(UsrRoleKey usrRoleKey : usrRoleKeyList) {
            usrAccountList.add(usrRoleKey.getUsrAccount());
        }

        List<Usr> usrList = usrDao.selectByPrimaryKeyList(usrAccountList);
        return usrList;
    }

    /**
     * 保存权限申请
     * @param applyRightProgress
     * @return
     */
    @PostMapping("/saveApplyRightProgress")
    public ApplyRightProgress saveApplyRightProgress(@Validated ApplyRightProgress applyRightProgress) {
        // 判断用户是否已经申请过权限, 如果已经申请则返回Null
        Usr usr = SessionUtils.getUsrFromSession();
        ApplyRightProgressKey key = new ApplyRightProgressKey();
        key.setUsrAccount(usr.getUsrAccount());
        key.setApplyRoleId(applyRightProgress.getApplyRoleId());
        if(applyRightProgressDao.selectByPrimaryKey(key) != null) {
            return null;
        }

        // 如果未申请权限则插入
        Role role = roleDao.selectByPrimaryKey(applyRightProgress.getApplyRoleId());
        Usr u = usrDao.selectByPrimaryKey(applyRightProgress.getApplyUsrAccount());

        applyRightProgress.setUsrAccount(usr.getUsrAccount());
        applyRightProgress.setApplyRoleName(role.getRoleName());
        applyRightProgress.setApplyUsrName(u.getUsrName());
        applyRightProgress.setApplyStateName("申请中");
        applyRightProgress.setApplyState(0);
        applyRightProgress.setCreateTime(new Date());

        applyRightProgressDao.insertSelective(applyRightProgress);
        return applyRightProgress;
    }

    /**
     * 获取用户申请权限的进程
     * @return
     */
    @PostMapping("/getApplyRightProgress")
    public List<ApplyRightProgress> getApplyRightProgress() {
        Usr usr = SessionUtils.getUsrFromSession();
        List<ApplyRightProgress> applyRightProgressesList = applyRightProgressDao.getApplyRightProgressByUsrAccount(usr.getUsrAccount());
        return applyRightProgressesList;
    }

    /**
     * 获取用户申请权限的进程
     * @return
     */
    @PostMapping("/getApplyRightProgressForPage")
    public List<ApplyRightProgress> getApplyRightProgressForPage(@Validated PageQueryParam pageQueryParam) {
        Usr usr = SessionUtils.getUsrFromSession();
        List<ApplyRightProgress> applyRightProgressesList = applyRightProgressDao.getApplyRightProgressByUsrAccountForPage(usr.getUsrAccount(),
                pageQueryParam.getCurrentIndex(), pageQueryParam.getPageSize());
        return applyRightProgressesList;
    }

    /**
     * 获取用户申请成功的权限
     * @param pageQueryParam
     * @return
     */
    @PostMapping("/getOwnedRightForPage")
    public List<ApplyRightProgress> getUsrRightForPageByState(@Validated PageQueryParam pageQueryParam) {
        // 获取申请通过的权限
        Integer applyState = 1;
        Usr usr = SessionUtils.getUsrFromSession();
        List<ApplyRightProgress> applyRightProgressesList = applyRightProgressDao.getApplyRightProgressByState(usr.getUsrAccount(),
                pageQueryParam.getCurrentIndex(), pageQueryParam.getPageSize(), applyState);
        return applyRightProgressesList;
    }

    @PostMapping("/deleteRoleByApplyRoleId")
    public int deleteRoleByApplyRoleId(String roleId) {
        Usr usr = SessionUtils.getUsrFromSession();
        ApplyRightProgressKey key = new ApplyRightProgressKey();
        key.setApplyRoleId(roleId);
        key.setUsrAccount(usr.getUsrAccount());
        ApplyRightProgress applyRightProgress = applyRightProgressDao.selectByPrimaryKey(key);
        applyRightProgress.setApplyState(-2);
        applyRightProgress.setApplyStateName("权限失效");
        applyRightProgressDao.updateByPrimaryKeySelective(applyRightProgress);

        UsrRoleKey usrRoleKey = new UsrRoleKey();
        usrRoleKey.setUsrAccount(usr.getUsrAccount());
        usrRoleKey.setRoleId(roleId);
        return usrRoleDao.deleteByPrimaryKey(usrRoleKey);
    }

}
