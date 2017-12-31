package com.oracle.test.serviceImpl;

import com.oracle.test.dao.AnswerDao;
import com.oracle.test.entity.Answer;
import com.oracle.test.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    private AnswerDao answerDao;

    @Override
    public void save(Answer answer) {
        answerDao.save(answer);
    }

    @Override
    public List<Answer> findAll() {
        return answerDao.findAll();
    }
}
