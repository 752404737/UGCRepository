package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.QuestionHandle;
import com.chinaunicom.management.entity.dto.QuestionHandleImg;

import java.util.List;

public interface QuestionHandleDao {
    List<QuestionHandle> getQuestionHandleDao();

    List<QuestionHandleImg> getQuestionProcess();


}
