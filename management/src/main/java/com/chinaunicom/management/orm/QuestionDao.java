package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.Question;
import com.chinaunicom.management.entity.QuestionComment;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestion();

    List<Question> getQuestionRd();

    List<Question> getQuestionUptime();

    List<Question> getQuestionPrioritySort();

    int getQuestionNum();

    int getQuestionTodayNum();

    int insertQuestion(Question question);

    int questionUpdate(Question question);

    List<QuestionComment> getQuestionComment();

    Question getQuestionDatils(String questionDetailId);

    int insertQuestionComment(String content, String usr_account, String questionid);

    int questionStateUpdate(String state, String id);


}
