package com.chinaunicom.management.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.management.entity.ApplyRightProgress;
import com.chinaunicom.management.entity.ApplyRightProgressKey;
import com.chinaunicom.management.entity.Usr;
import com.chinaunicom.management.entity.UsrRoleKey;
import com.chinaunicom.management.entity.dto.PageQueryParam;
import com.chinaunicom.management.orm.ApplyRightProgressDao;
import com.chinaunicom.management.orm.UsrDao;
import com.chinaunicom.management.orm.UsrRoleDao;
import com.chinaunicom.management.util.HttpUtils;
import com.chinaunicom.management.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-11 上午9:54
 */
@RestController
public class DealRightController {

    @Autowired
    private ApplyRightProgressDao applyRightProgressDao;

    @Autowired
    private UsrDao usrDao;

    @Autowired
    private UsrRoleDao usrRoleDao;

    /*@PostMapping("/getAdminBackLog")
    public void getAdminBackLog(HttpServletResponse response) {
        Usr usr = SessionUtils.getUsrFromSession();
        List<ApplyRightProgress> applyRightProgressList = applyRightProgressDao.getApplyRightProgressByApplyUsrAccount(usr.getUsrAccount());
        JSONArray jsonArray = new JSONArray();
        for(ApplyRightProgress arp : applyRightProgressList) {
            Usr u = usrDao.selectByPrimaryKey(arp.getUsrAccount());
            if (u == null) continue;
            JSONObject obj = new JSONObject();
            obj.put("usrAccount", u.getUsrAccount());
            obj.put("usrName", u.getUsrName());
            obj.put("applyRoleId", arp.getApplyRoleId());
            obj.put("roleName", arp.getApplyRoleName());
            obj.put("createTime", arp.getCreateTime());
            jsonArray.add(obj);
        }
        HttpUtils.printJsonToResponse(response, jsonArray);
    }*/

    /**
     * 分页查询待办事件数量
     * @param response
     * @param pageQueryParam
     */
    @PostMapping("/getAdminBackLogForPage")
    public void getAdminBackLogForPage(HttpServletResponse response, @Validated PageQueryParam pageQueryParam) {
        Usr usr = SessionUtils.getUsrFromSession();
        List<ApplyRightProgress> applyRightProgressList = applyRightProgressDao.getApplyRightProgressByApplyUsrAccountForPage(usr.getUsrAccount(),
                pageQueryParam.getCurrentIndex(), pageQueryParam.getPageSize());
        JSONArray jsonArray = new JSONArray();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(ApplyRightProgress arp : applyRightProgressList) {
            Usr u = usrDao.selectByPrimaryKey(arp.getUsrAccount());
            if (u == null) continue;
            JSONObject obj = new JSONObject();
            obj.put("avatar", u.getUsrHeadportraitUrl());
            obj.put("usrAccount", u.getUsrAccount());
            obj.put("usrName", u.getUsrName());
            obj.put("applyRoleId", arp.getApplyRoleId());
            obj.put("roleName", arp.getApplyRoleName());
            obj.put("createTime", sdf.format(arp.getCreateTime()));
            jsonArray.add(obj);
        }
        HttpUtils.printJsonToResponse(response, jsonArray);
    }

    /**
     * 获取待办事项数量
     * @param response
     */
    @PostMapping("/getBackLogCount")
    public void getBackLogCount(HttpServletResponse response) {
        Usr usr = SessionUtils.getUsrFromSession();
        List<ApplyRightProgress> applyRightProgressList = applyRightProgressDao.getApplyRightProgressByApplyUsrAccount(usr.getUsrAccount());
        JSONObject obj = new JSONObject();
        if (applyRightProgressList == null) {
            obj.put("count", 0);
        } else {
            obj.put("count", applyRightProgressList.size());
        }
        HttpUtils.printJsonToResponse(response, obj);
    }

    /**
     * 拒绝权限申请
     * @param response
     * @param usrAccount
     * @param applyRoleId
     */
    @PostMapping("/refuseApplyRight")
    public void refuseApplyRight(HttpServletResponse response, String usrAccount, String applyRoleId) {
        JSONObject result = new JSONObject();

        ApplyRightProgressKey key = new ApplyRightProgressKey();
        key.setUsrAccount(usrAccount);
        key.setApplyRoleId(applyRoleId);
        ApplyRightProgress applyRightProgress = applyRightProgressDao.selectByPrimaryKey(key);
        if (applyRightProgress == null) {
            result.put("success", 0);
            HttpUtils.printJsonToResponse(response, result);
            return;
        }

        applyRightProgress.setApplyState(-1);
        applyRightProgress.setApplyStateName("申请失败");
        int success = applyRightProgressDao.updateByPrimaryKeySelective(applyRightProgress);
        result.put("success", success);
        HttpUtils.printJsonToResponse(response, result);
    }

    /**
     * 同意权限申请
     * @param response
     * @param usrAccount
     * @param applyRoleId
     */
    @PostMapping("/acceptApplyRight")
    public void acceptApplyRight(HttpServletResponse response, String usrAccount, String applyRoleId) {
        JSONObject result = new JSONObject();

        // 更新申请权限进程表
        ApplyRightProgressKey key = new ApplyRightProgressKey();
        key.setUsrAccount(usrAccount);
        key.setApplyRoleId(applyRoleId);
        ApplyRightProgress applyRightProgress = applyRightProgressDao.selectByPrimaryKey(key);
        if (applyRightProgress == null) {
            result.put("success", 0);
            HttpUtils.printJsonToResponse(response, result);
            return;
        }
        applyRightProgress.setApplyState(1);
        applyRightProgress.setApplyStateName("申请成功");
        applyRightProgressDao.updateByPrimaryKeySelective(applyRightProgress);

        // 更新用户角色表
        UsrRoleKey usrRoleKey = new UsrRoleKey();
        usrRoleKey.setUsrAccount(usrAccount);
        usrRoleKey.setRoleId(applyRoleId);
        usrRoleDao.deleteByPrimaryKey(usrRoleKey);
        int success = usrRoleDao.insertSelective(usrRoleKey);

        result.put("success", success);
        HttpUtils.printJsonToResponse(response, result);

    }

}
