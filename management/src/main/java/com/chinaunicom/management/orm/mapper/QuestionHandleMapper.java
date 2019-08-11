package com.chinaunicom.management.orm.mapper;

import com.chinaunicom.management.entity.QuestionHandle;
import com.chinaunicom.management.entity.dto.QuestionHandleImg;

import java.util.List;

public interface QuestionHandleMapper {
    List<QuestionHandle> getQuestionHandle();

    List<QuestionHandleImg> getQuestionProcess();
}
