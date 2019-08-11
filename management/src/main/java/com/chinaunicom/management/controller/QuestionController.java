package com.chinaunicom.management.controller;
//1
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaunicom.management.entity.*;
import com.chinaunicom.management.entity.dto.QuestionHandleImg;
import com.chinaunicom.management.orm.QuestionDao;
import com.chinaunicom.management.orm.QuestionHandleDao;
import com.chinaunicom.management.orm.UsrRoleDao;
import com.chinaunicom.management.util.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private QuestionHandleDao questionHandleDao;

    @Autowired
    private UsrRoleDao usrRoleDao;


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

    //站内信息（新问题、解决问题、关闭问题14天每天统计数）
    @PostMapping("/questionHandle")
    public JSONArray questionHandle() {
        JSONArray jsonArray = new JSONArray();
        List a = questionHandleDao.getQuestionHandleDao();//所有数据
        QuestionHandle questionHandle = (QuestionHandle) a.get(0);//获取第一个
        String dateTemp = questionHandle.getDate().toString();//获取第一个的日期
        int numNew = 0;
        int numSlove = 0;
        int numClose = 0;
        QuestionHandle questionHandleTmpppp = null;
        String dateppp = null;
        for (int i = 0; i < a.size(); i++) {
            JSONObject object = new JSONObject();
            QuestionHandle questionHandleTmp = (QuestionHandle) a.get(i);//获取第i个
            String date = questionHandleTmp.getDate().toString();//获取第i个的日期
            if (i > 1) {
                questionHandleTmpppp = (QuestionHandle) a.get(i - 1);//获取第i-1个
                dateppp = questionHandleTmpppp.getDate().toString();
            }//获取第i-1个的日期
            if (date.equals(dateTemp) != true) {
                object.put("日期", ((QuestionHandle) a.get(i - 1)).getDate());
                object.put("新问题数量", numNew);
                object.put("解决问题数量", numSlove);
                object.put("关闭问题数量", numClose);
                jsonArray.add(object);
                numNew = 0;
                numSlove = 0;
                numClose = 0;
                dateTemp = date;
            }
            if (date.equals(dateTemp) && i != (a.size() - 1)) {
                if (questionHandleTmp.getType().contains("新问题")) {
                    numNew++;
                }
                if (questionHandleTmp.getType().contains("解决问题")) {
                    numSlove++;
                }
                if (questionHandleTmp.getType().contains("关闭问题")) {
                    numClose++;
                }
            }
            if (!date.equals(dateppp) && i == (a.size() - 1)) {
                JSONObject bb = new JSONObject();
                bb.put("日期", ((QuestionHandle) a.get(i)).getDate());
                if (questionHandleTmp.getType().contains("新问题")) {
                    numNew++;
                }
                if (questionHandleTmp.getType().contains("解决问题")) {
                    numSlove++;
                }
                if (questionHandleTmp.getType().contains("关闭问题")) {
                    numClose++;
                }
                bb.put("新问题数量", numNew);
                bb.put("解决问题数量", numSlove);
                bb.put("关闭问题数量", numClose);
                jsonArray.add(bb);
            }
            dateTemp = date;
        }
        return jsonArray;
    }

    //问题评论
    @PostMapping("/questionComment")
    public JSONArray questionComment() {
        JSONArray jsonArray = new JSONArray();
        List list = questionDao.getQuestionComment();
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            QuestionComment questionComment = (QuestionComment) list.get(i);
            jsonObject.put("name", questionComment.getUsr_name());
            jsonObject.put("avatar", questionComment.getUsr_headportrait_url());
            jsonObject.put("date", questionComment.getDate());
            jsonObject.put("content", questionComment.getContent());
            jsonObject.put("task", questionComment.getQuestion());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    //操作记录进程
    @PostMapping("/questionProcess")
    public JSONArray questionProcess() {
        JSONArray jsonArray = new JSONArray();
        List list = questionHandleDao.getQuestionProcess();
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            QuestionHandleImg questionHandleImg = (QuestionHandleImg) list.get(i);
            jsonObject.put("date", questionHandleImg.getDate());
            jsonObject.put("name", questionHandleImg.getUsr_name());
            jsonObject.put("opt", questionHandleImg.getType());
            jsonObject.put("task", questionHandleImg.getId());
            jsonObject.put("avatar", questionHandleImg.getUsr_headportrait_url());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    //创建问题
    @PostMapping("/questionCreate")
    public void questionCreate(@Validated Question question) {
        Usr usr = SessionUtils.getUsrFromSession();
        question.setWriter(usr.getUsrName());
        int a = questionDao.getQuestionNum() + 1;
        String str = String.format("%03d", a);
        question.setId("IP-" + str);
        questionDao.insertQuestion(question);
    }

    //问题详情
    @PostMapping("/questionDetails")
    public JSONObject questionDetails(HttpServletRequest request, Model model) throws ParseException {
        Usr usr = SessionUtils.getUsrFromSession();
        String questionDetailId = request.getParameter("questionDetailId");
        Question question = questionDao.getQuestionDatils(questionDetailId);
        JSONObject jsonObject = new JSONObject();
        List list = usrRoleDao.getRoleIdByUsrAccount(usr.getUsrAccount());
        for (int i = 0; i < list.size(); i++) {
            UsrRoleKey usrRoleKey = (UsrRoleKey) list.get(i);
            if (usrRoleKey.getRoleId().equals("pm")) {
                jsonObject.put("关闭任务", true);
                jsonObject.put("编辑任务", true);
                jsonObject.put("开始项目", true);
                jsonObject.put("规划完成", true);
                jsonObject.put("开始验收", true);
                jsonObject.put("验收完成", true);
                jsonObject.put("项目已上线", true);
                jsonObject.put("线上测试通过", true);
            }
            if (usrRoleKey.getRoleId().equals("rd")) {
                jsonObject.put("开始开发", true);
                jsonObject.put("开发完成", true);
            }
            if (usrRoleKey.getRoleId().equals("test")) {
                jsonObject.put("开始开发", true);
                jsonObject.put("开发完成", true);
            }
        }
        jsonObject.put("链接任务", true);
        jsonObject.put("type", question.getType());
        jsonObject.put("state", question.getState());
        jsonObject.put("Priority", question.getPriority());
        if (question.getState().equals("已解决")) {
            jsonObject.put("result", "已解决");
        } else {
            jsonObject.put("result", "未解决");
        }
        jsonObject.put("description", question.getDescription());
        jsonObject.put("connect", question.getConnect());
        jsonObject.put("pm", question.getPm());
        jsonObject.put("dev", question.getDev());
        jsonObject.put("tester", question.getTester());
        jsonObject.put("date", question.getDate());
        jsonObject.put("lastsaved", question.getLastsaved());
        return jsonObject;
    }

    //问题编辑
    @PostMapping("/questionEdit")
    public void questionEdit(HttpServletRequest request, @Validated Question question) {
        String questionDetailId = request.getParameter("id");
        question.setId(questionDetailId);
        questionDao.questionUpdate(question);
    }

    //问题状态变更
    @PostMapping("/questionStateChange")
    public void questionStateChange(HttpServletRequest request) {

        String string = request.getParameter("state");
        String state = null;
        switch (string) {
            case "开始项目":
                state = "项目规划中";
                break;
            case "规划完成":
                state = "待研发";
                break;
            case "开始开发":
                state = "研发中";
                break;
            case "开发完成":
                state = "待验收";
                break;
            case "开始验收":
                state = "验收中";
                break;
            case "验收完成":
                state = "待测试";
                break;
            case "开始测试":
                state = "测试中";
                break;
            case "测试完成":
                state = "等待上线中";
                break;
            case "项目已上线":
                state = "线上测试中";
                break;
            case "线上测试通过":
                state = "已完成";
                break;
            case "关闭任务":
                state = "已关闭";
                break;
            default:
                break;
        }
        String id = request.getParameter("id");
        questionDao.questionStateUpdate(state, id);
    }

    //问题评论
    @PostMapping("/questionNewComment")
    public void questionNewComment(HttpServletRequest request) {
        Usr usr = SessionUtils.getUsrFromSession();
        String content = request.getParameter("comment");
        String usr_account = usr.getUsrAccount();
        String questionid = request.getParameter("questionId");
        questionDao.insertQuestionComment(content, usr_account, questionid);

    }

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

    //研发工作面板中心
    @PostMapping("/rdCenter")
    public JSONArray rdCenter() {
        JSONArray jsonArray = new JSONArray();
        List a = questionDao.getQuestionRd();
        for (int i = 0; i < a.size(); i++) {
            JSONObject object = new JSONObject();
            Question question = (Question) a.get(i);
            object.put("状态", question.getState());
            object.put("编号", question.getId());
            object.put("名称", question.getQuestion());
            object.put("优先级", question.getPriority());
//            object.put("测试人员", question.getTester());
//            object.put("产品经理", question.getPm());
            jsonArray.add(object);
        }
        return jsonArray;
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
