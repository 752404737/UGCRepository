package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.*;
import com.chinaunicom.management.orm.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionDaoImp implements QuestionDao {
    @Resource
    private QuestionMapper questionMapper;


    @Override
    public List<Question> getQuestionSort(Integer currentIndex, Integer pageSize) {
        return questionMapper.getQuestionSort(currentIndex, pageSize);
    }

    @Override
    public List<Question> getQuestion() {
        return questionMapper.getQuestion();
    }

    @Override
    public List<Question> getQuestionRd() {
        return questionMapper.getQuestionRd();
    }

    @Override
    public List<Question> getQuestionUptime() {
        return questionMapper.getQuestionUptime();
    }

    @Override
    public List<Question> getQuestionPrioritySort() {
        return questionMapper.getQuestionPrioritySort();
    }

    @Override
    public int getQuestionNum() {
        return questionMapper.getQuestionNum();
    }

    @Override
    public int getQuestionTodayNum() {
        return questionMapper.getQuestionTodayNum();
    }

    @Override
    public int insertQuestion(Question question) {
        return questionMapper.insertQuestion(question);
    }

    @Override
    public int questionUpdate(Question question) {
        return questionMapper.questionUpdate(question);
    }

    @Override
    public int questionConnectUpdate(String connect, String id) {
        return questionMapper.questionConnectUpdate(connect, id);
    }

    @Override
    public List<QuestionComment> getQuestionComment() {
        return questionMapper.getQuestionComment();
    }

    @Override
    public Question getQuestionDatils(String questionDetailId) {
        return questionMapper.getQuestionDetails(questionDetailId);
    }

    @Override
    public List<QuestionToDo> getQuestionToDo(Integer currentIndex, Integer pageSize) {
        return questionMapper.getQuestionToDo(currentIndex, pageSize);
    }

    @Override
    public List<QuestionToDo> getQuestionToDoNum() {
        return questionMapper.getQuestionToDoNum();
    }


    @Override
    public int insertQuestionComment(String content, String usr_account, String questionid) {
        return questionMapper.insertQuestionComment(content, usr_account, questionid);
    }

    @Override
    public int insertQuestionProcess(String usr_account, String type, String questionid) {
        return questionMapper.insertQuestionProcess(usr_account, type, questionid);
    }

    @Override
    public int questionStateUpdate(String state, String id) {
        return questionMapper.questionStateUpdate(state, id);
    }

    @Override
    public List<QuestionOneComment> getQuestionOneComment(String questionid) {
        return questionMapper.getQuestionOneComment(questionid);
    }

    @Override
    public List<QuestionOneProcess> getQuestionOneProcess(String questionid) {
        return questionMapper.getQuestionOneProcess(questionid);
    }
}
