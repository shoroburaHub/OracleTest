package com.oracle.test.controller;

import com.oracle.test.entity.Question;
import com.oracle.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 1/8/2018.
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/getComment/{questionId}")
    public @ResponseBody String getComment(@PathVariable Long questionId) {
        return questionService.getComment(questionId);
    }

    @PostMapping("/saveComment/{questionId}")
    public @ResponseBody
    HttpStatus saveComment(@PathVariable Long questionId, @RequestBody String comment) {
        Question question = questionService.findOne(questionId);
        question.setExplanation(comment);
        questionService.update(question);
        return HttpStatus.OK;
    }
}
