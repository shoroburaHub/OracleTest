package com.oracle.test.serviceImpl;

import com.oracle.test.dao.QuestionDao;
import com.oracle.test.entity.Answer;
import com.oracle.test.entity.Question;
import com.oracle.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public List<Question> findAllQuestionsWithAnswers(long id) {
        List<Question> questions = questionDao.findAllQuestionsWithAnswers(id);
        for (Question question : questions) {
            question.setProblemStatement("<div><pre>" + question.getProblemStatement().replaceAll("///", "") + "</pre></div>");
            for (Answer answer : question.getAnswers()) {
                answer.setText("<pre>" + answer.getText().replaceAll("///", "") + "</pre>");
            }
        }
        return questions;
    }
}
