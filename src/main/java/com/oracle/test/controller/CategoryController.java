package com.oracle.test.controller;

import com.oracle.test.entity.Question;
import com.oracle.test.service.CategoryService;
import com.oracle.test.service.InitService;
import com.oracle.test.service.QuestionService;
import com.oracle.test.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/category/{id}")
    public String openCategory(Model model, @PathVariable Long id){
        model.addAttribute("category", categoryService.findCategoryWithSubCategories(id));
        return "category";
    }
    @GetMapping("/random/{categoryId}")
    public String random(Model model, @PathVariable Long categoryId) {
        model.addAttribute("questions", questionService.random(categoryId));
        return "random";
    }

}

