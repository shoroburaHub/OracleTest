package com.oracle.test.serviceImpl;

import com.oracle.test.dao.AnswerDao;
import com.oracle.test.dao.CategoryDao;
import com.oracle.test.dao.QuestionDao;
import com.oracle.test.dao.SubCategoryDao;
import com.oracle.test.entity.Answer;
import com.oracle.test.entity.Category;
import com.oracle.test.entity.Question;
import com.oracle.test.entity.Subcategory;
import com.oracle.test.misc.PrepReader;
import com.oracle.test.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private SubCategoryDao subCategoryDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;

    @Override
    public void init() {

        final Category ocaCategory = new Category("Oracle Certified Associate, Java SE 7 Programmer");
//        final Category ocjpCategory = new Category("Oracle Certified Professional, Java SE 7 Programmer");
//        final Category ejbCategory = new Category("Enterprise JavaBeans Developer");
//        final Category jpaCategory = new Category("Java saveence API Developer");
//        final Category webComponentCategory = new Category("Web Component Developer");
//        final Category webServicesDeveloper = new Category("Web Services Developer");

        categoryDao.save(ocaCategory);
//        categoryDao.save(webServicesDeveloper);
//        categoryDao.save(ocjpCategory);
//        categoryDao.save(ejbCategory);
//        categoryDao.save(jpaCategory);
//        categoryDao.save(webComponentCategory);

        fillDb(ocaCategory, "japv7.ets");
//        fillDb(ocjpCategory, "jqplusv7.ets");
//        fillDb(ejbCategory, "ejbplusv6.ets");
//        fillDb(jpaCategory, "jpapv6.ets");
//        fillDb(webServicesDeveloper, "jwspv6.ets");
//        fillDb(webComponentCategory, "jwpv6.ets");
    }

    private void fillDb(final Category category, final String fileName) {
        final HashMap<String, Question> questionMap = new HashMap<>();
        final HashMap<String, List<Answer>> answers = new HashMap<>();
        final HashMap<Integer, Subcategory> sectionMap = new HashMap<>();
        final HashMap<Integer, List<String>> sectionToQuestionMap = new HashMap<>();
        final List<HashMap> maps = PrepReader.getMaps(fileName);
        int i = 0;
        for (HashMap database : maps) {
            final String cn = (String) database.get("cn");
            if ("so.Question".equals(cn)) {
                for (Object[] entry : (ArrayList<Object[]>) database.get("data")) {
                    final Question entity = new Question();
                    entity.setToughness((Integer) entry[1]);
                    entity.setProblemStatement((String) entry[2]);
                    entity.setIsProblemStatementInHtml((Boolean) entry[3]);
                    entity.setExplanation((String) entry[7]);
                    entity.setIsExplanationInHtml((Boolean) entry[6]);
                    entity.setiType((Integer) entry[13]);
                    questionMap.put((String) entry[0], entity);
                }
            } else if ("questionspecificpart".equals(cn)) {
                for (Object[] entry : (ArrayList<Object[]>) database.get("data")) {
                    final Answer entity = new Answer();
                    entity.setText((String) entry[1]);
                    entity.setComment((String) entry[2]);
                    entity.setCorrect((Boolean) entry[3]);
                    entity.setIsTextInHtml((Boolean) entry[4]);

                    String qid = (String) entry[0];
                    List<Answer> answerList = answers.get(qid);
                    if (answerList == null) {
                        answerList = new ArrayList<>();
                        answers.put(qid, answerList);
                    }
                    answerList.add(entity);
                }
            } else if ("so.Section".equals(cn)) {
                for (Object[] entry : (ArrayList<Object[]>) database.get("data")) {
                    final Subcategory entity = new Subcategory();
                    entity.setName((String) entry[1]);
                    entity.setDescription((String) entry[2]);
                    sectionMap.put((Integer) entry[0], entity);
                }
            } else if ("qsmap".equals(cn)) {
                for (Object[] entry : (ArrayList<Object[]>) database.get("data")) {
                    final Integer sectionId = (Integer) entry[1];
                    List<String> questionList = sectionToQuestionMap.get(sectionId);
                    if (questionList == null) {
                        questionList = new ArrayList<>();
                        sectionToQuestionMap.put(sectionId, questionList);
                    }
                    questionList.add((String) entry[0]);
                }
            }
        }
        category.setSubcategorys(new ArrayList<Subcategory>());
        for (final Integer sectionId : sectionMap.keySet()) {
            final Subcategory section = sectionMap.get(sectionId);
            section.setQuestions(new ArrayList<Question>());
            section.setCategory(category);
            category.getSubcategorys().add(section);
            subCategoryDao.save(section);
            final List<String> qids = sectionToQuestionMap.get(sectionId);
            for (final String qid : qids) {
                final Question question = questionMap.get(qid);
                question.setCategory(section);
                question.setAnswers(new ArrayList<Answer>());
                section.getQuestions().add(question);
                final List<Answer> answerList = answers.get(qid);
                if (answerList == null) {
                    continue;
                }
                questionDao.save(question);
                for (Answer ans : answerList) {
                    ans.setQuestion(question);
                    answerDao.save(ans);
                    question.getAnswers().add(ans);
                }
            }
        }
    }

}
