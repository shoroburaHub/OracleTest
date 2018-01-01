package com.oracle.test.controller;

import com.oracle.test.service.QuestionService;
import com.oracle.test.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by admin on 12/30/2017.
 */
@Controller
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/subcategory/{id}")
    public String subCategory(Model model, @PathVariable long id){
        model.addAttribute("subCategory", subCategoryService.findOne(id));
        model.addAttribute("questions", questionService.findAllQuestionsWithAnswers(id));
        return "subCategory";
    }

}
