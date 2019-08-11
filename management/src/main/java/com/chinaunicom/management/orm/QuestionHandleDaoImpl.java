package com.chinaunicom.management.orm;

import com.chinaunicom.management.entity.QuestionHandle;
import com.chinaunicom.management.entity.dto.QuestionHandleImg;
import com.chinaunicom.management.orm.mapper.QuestionHandleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionHandleDaoImpl implements QuestionHandleDao {

    @Resource
    QuestionHandleMapper questionHandleMapper;

    @Override
    public List<QuestionHandle> getQuestionHandleDao() {
        return questionHandleMapper.getQuestionHandle();
    }

    @Override
    public List<QuestionHandleImg> getQuestionProcess() {
        return questionHandleMapper.getQuestionProcess();
    }
}
