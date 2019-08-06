package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestion();

    List<Question> getQuestionUptime();

    List<Question> getQuestionPrioritySort();

    int getQuestionNum();

    int getQuestionTodayNum();
}
