package com.oracle.test.dao;

import com.oracle.test.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface QuestionDao extends JpaRepository<Question, Long> {
    @Query("select distinct q from Question q left join fetch q.answers where q.category.id = ?1")
    List<Question> findAllQuestionsWithAnswers(long id);
}
