package com.oracle.test.service;

import com.oracle.test.entity.Answer;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface AnswerService {

    void save(Answer answer);
    List<Answer> findAll();

}
