package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.Question;

import java.util.List;

public interface QuestionMapper {
    List<Question> getQuestion();

    List<Question> getQuestionUptime();

    List<Question> getQuestionPrioritySort();

    int getQuestionNum();

    int getQuestionTodayNum();

    int insertQuestion(Question question);
}

