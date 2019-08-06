package com.chinaunicom.management.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.management.entity.Question;
import com.chinaunicom.management.orm.QuestionDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class QuestionController {
    private static Logger logger = LogManager.getLogger(QuestionController.class);

    @Autowired
    private QuestionDao questionDao;

    //问题总数统计
    @GetMapping("/questionNum")
    public Integer questionNum() {
        int a = questionDao.getQuestionNum();
        return a;
    }

    //今日问题数量统计
    @GetMapping("/questionTodayNum")
    public Integer questionTodayNum() {
        int b = questionDao.getQuestionTodayNum();
        return b;
    }

    //新问题、解决问题、关闭问题14天每天统计数

    //问题类型数量统计
    @GetMapping("/questionTypeNum")
    public JSONObject questionTypeNum() {
        int iosNum = 0;
        int androidNum = 0;
        int bigdataNum = 0;
        int iotNum = 0;
        List a = questionDao.getQuestion();
        for (int i = 0; i < a.size(); i++) {
            Question question = (Question) a.get(i);
            if (question.getType().contains("ios")) {
                iosNum++;
            }
            if (question.getType().contains("安卓")) {
                androidNum++;
            }
            if (question.getType().contains("大数据")) {
                bigdataNum++;
            }
            if (question.getType().contains("物联网")) {
                iotNum++;
            }
        }
        JSONObject object = new JSONObject();
        object.put("移动端IOS问题", iosNum);
        object.put("移动端安卓问题", androidNum);
        object.put("大数据研发问题", bigdataNum);
        object.put("物联网研发问题", iotNum);
        return object;
        //return questionDao.getQuestion();
    }

    //问题池筛选
    @GetMapping("/screen")
    public JSONArray screen(HttpServletRequest request, Model model) throws ParseException {
        String type = request.getParameter("type");
        String writer = request.getParameter("writer");
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDown = null;
        Date dateUp = null;
        Date dateReal;
        try {
            dateDown = format.parse(date1);
            dateUp = format.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List a = questionDao.getQuestion();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < a.size(); i++) {
            JSONObject object = new JSONObject();
            Question question = (Question) a.get(i);
            Date time = new Date(question.getDate().toString());
            String dateTemp = format.format(time);
            dateReal = format.parse(dateTemp);
            if (question.getType().equals(type) && question.getWriter().equals(writer) && dateReal.compareTo(dateDown) > 0 && dateReal.compareTo(dateUp) < 0) {
                object.put("编号", question.getId());
                object.put("名称", question.getQuestion());
                object.put("类型", question.getType());
                object.put("创建人", question.getWriter());
                object.put("时间", question.getDate());
                jsonArray.add(object);
            }
        }
        return jsonArray;
    }

    //问题状态数量统计
    @GetMapping("/questionStateNum")
    public JSONObject questionStateNum() {
        int daikaifaNum = 0;
        int kaifazhongNum = 0;
        int ceshizhongNum = 0;
        int dengdaishangxianNum = 0;
        List a = questionDao.getQuestion();
        for (int i = 0; i < a.size(); i++) {
            Question question = (Question) a.get(i);
            if (question.getState().contains("待开发")) {
                daikaifaNum++;
            }
            if (question.getState().contains("开发中")) {
                kaifazhongNum++;
            }
            if (question.getState().contains("测试中")) {
                ceshizhongNum++;
            }
            if (question.getState().contains("等待上线")) {
                daikaifaNum++;
            }
        }
        JSONObject object = new JSONObject();
        object.put("待开发", daikaifaNum);
        object.put("开发中", kaifazhongNum);
        object.put("测试中", ceshizhongNum);
        object.put("等待上线", dengdaishangxianNum);
        return object;
    }

    //等待上线具体事项筛选
    @GetMapping("/itemScreen")
    public JSONArray itemScreen(HttpServletRequest request, Model model) throws ParseException {
        String screenType = request.getParameter("screenType");
        JSONArray jsonArray = new JSONArray();
        if (screenType.equals("所有事项")) {
            List a = questionDao.getQuestion();
            for (int i = 0; i < a.size(); i++) {
                JSONObject object = new JSONObject();
                Question question = (Question) a.get(i);
                object.put("编号", question.getId());
                object.put("名称", question.getQuestion());
                object.put("优先级", question.getPriority());
                object.put("测试人员", question.getTester());
                object.put("产品经理", question.getPm());
                jsonArray.add(object);
            }
        }
        if (screenType.equals("优先事项")) {
            List b = questionDao.getQuestionPrioritySort();
            for (int i = 0; i < b.size(); i++) {
                JSONObject object = new JSONObject();
                Question question = (Question) b.get(i);
                object.put("编号", question.getId());
                object.put("名称", question.getQuestion());
                object.put("优先级", question.getPriority());
                object.put("测试人员", question.getTester());
                object.put("产品经理", question.getPm());
                jsonArray.add(object);
            }
        }
        return jsonArray;
    }

    //等待上线数量统计
    @GetMapping("/questionWaitUptimeNum")
    public JSONArray questionWaitUptimeNum() throws ParseException {
        JSONArray jsonArray = new JSONArray();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List a = questionDao.getQuestionUptime();
        Question question1 = (Question) a.get(0);
        String dateTemp = question1.getUptime().toString();
        int num = 0;
        for (int i = 0; i < a.size(); i++) {
            JSONObject object = new JSONObject();
            Question question = (Question) a.get(i);
            String date = question.getUptime().toString();
            if (date.equals(dateTemp) != true) {
                object.put("上传时间", ((Question) a.get(i - 1)).getUptime());
                object.put("等待数量", num);
                jsonArray.add(object);
                num = 0;
                dateTemp = date;
            }
            if (date.equals(dateTemp)) {
                num++;
            }
            if (i == (a.size() - 1)) {
                object.put("上传时间", ((Question) a.get(i - 1)).getUptime());
                object.put("等待数量", num);
                jsonArray.add(object);
            }
        }
        return jsonArray;
    }
}
