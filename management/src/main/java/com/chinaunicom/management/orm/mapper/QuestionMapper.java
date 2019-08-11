package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.Question;
import com.chinaunicom.management.entity.QuestionComment;

import java.util.List;

public interface QuestionMapper {
    List<Question> getQuestion();

    List<Question> getQuestionRd();

    List<Question> getQuestionUptime();

    List<Question> getQuestionPrioritySort();

    int getQuestionNum();

    int getQuestionTodayNum();

    int insertQuestion(Question question);

    int questionUpdate(Question question);

    int questionStateUpdate(String state, String id);

    List<QuestionComment> getQuestionComment();

    Question getQuestionDetails(String questionDetailId);

    int insertQuestionComment(String content, String usr_account, String questionid);
}

