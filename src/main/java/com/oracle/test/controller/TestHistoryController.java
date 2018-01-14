package com.oracle.test.controller;

import com.oracle.test.entity.TestHistory;
import com.oracle.test.service.TestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * Created by admin on 1/14/2018.
 */
@Controller
public class TestHistoryController {

    @Autowired
    private TestHistoryService testHistoryService;

    @PostMapping("/saveHistory/{questionSize}/{answerSize}")
    public @ResponseBody HttpStatus saveHistory(@PathVariable Long questionSize, @PathVariable Long answerSize) {
        TestHistory testHistory = new TestHistory(LocalDateTime.now(), ""+answerSize+" / "+questionSize);
        System.out.println("testHistory = " + testHistory);
        testHistoryService.save(testHistory);
        return HttpStatus.OK;
    }

}
