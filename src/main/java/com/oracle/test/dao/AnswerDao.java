package com.oracle.test.dao;

import com.oracle.test.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface AnswerDao extends JpaRepository<Answer, Long>{
}
