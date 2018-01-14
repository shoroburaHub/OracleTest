package com.oracle.test.serviceImpl;

import com.oracle.test.dao.CategoryDao;
import com.oracle.test.dao.QuestionDao;
import com.oracle.test.dao.SubCategoryDao;
import com.oracle.test.entity.Answer;
import com.oracle.test.entity.Question;
import com.oracle.test.entity.Subcategory;
import com.oracle.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 12/30/2017.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private SubCategoryDao subCategoryDao;

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
            question.setProblemStatement(styleText(question.getProblemStatement().replaceAll("///", "")));
            for (Answer answer : question.getAnswers()) {
                answer.setText(answer.getText().replaceAll("///", ""));
            }
        }
        return questions;
    }

    @Override
    public List<Question> random(Long categoryId) {
        List<Question> questionsRandom = new ArrayList<>();
        List<Subcategory> subcategories= subCategoryDao.findAllByCategoryId(categoryId);
        List<Question> allQuestions = new ArrayList<>();
        for (Subcategory subcategory : subcategories) {
            allQuestions.addAll(questionDao.findAllQuestionsWithAnswers(subcategory.getId()));
        }

        Random random = new Random();

        for (int i = 0; i < 25; i++) {
            int rand = random.nextInt(allQuestions.size());
            Question question = allQuestions.get(rand);
            question.setProblemStatement(styleText(question.getProblemStatement().replaceAll("///", "")));
            for (Answer answer : question.getAnswers()) {
                answer.setText(answer.getText().replaceAll("///", ""));
            }
            questionsRandom.add(question);
        }
        return questionsRandom;
    }

    public String styleText(String text) {
        return "<pre>" + text + "</pre>";
    }

    @Override
    public Question findOne(long id) {
        return questionDao.findOne(id);
    }

    @Override
    public void update(Question question) {
        question.setExplanation(question.getExplanation().replaceAll("\"", ""));
        questionDao.save(question);
    }

    @Override
    public String getComment(Long id) {
        Question question = questionDao.findOne(id);
        question.setExplanation(question.getExplanation().replaceAll("///", ""));
        return question.getExplanation();
    }
}
