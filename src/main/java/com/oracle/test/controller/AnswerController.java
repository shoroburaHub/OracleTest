package com.oracle.test.controller;

import com.oracle.test.dto.DtoUtilMapper;
import com.oracle.test.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin on 1/1/2018.
 */
@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/checkAnswer/{questionId}")
    public @ResponseBody
    ResponseEntity checkAnswer(@PathVariable Long questionId) {
        return new ResponseEntity(DtoUtilMapper.answersToAnswerDtos(answerService.findAllByQuestionId(questionId)), HttpStatus.OK);
    }

}
