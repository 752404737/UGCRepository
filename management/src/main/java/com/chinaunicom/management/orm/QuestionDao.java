package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.*;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestionSort(Integer currentIndex, Integer pageSize);

    List<Question> getQuestion();

    List<Question> getQuestionRd();

    List<Question> getQuestionUptime();

    List<Question> getQuestionPrioritySort();

    int getQuestionNum();

    int getQuestionTodayNum();

    int insertQuestion(Question question);

    int questionUpdate(Question question);

    int questionConnectUpdate(String connect,String id);


    List<QuestionComment> getQuestionComment();

    Question getQuestionDatils(String questionDetailId);

    List<QuestionToDo> getQuestionToDo(Integer currentIndex, Integer pageSize);

    List<QuestionToDo> getQuestionToDoNum();

    int insertQuestionComment(String content, String usr_account, String questionid);

    int insertQuestionProcess(String usr_account,String type,String questionid);


    int questionStateUpdate(String state, String id);

    List<QuestionOneComment> getQuestionOneComment(String questionid);

    List<QuestionOneProcess> getQuestionOneProcess(String questionid);

}
