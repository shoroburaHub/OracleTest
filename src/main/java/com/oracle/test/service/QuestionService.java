package com.oracle.test.service;

import com.oracle.test.entity.Question;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface QuestionService {
    void save(Question question);

    List<Question> findAll();

    List<Question> findAllQuestionsWithAnswers(long id);
}
