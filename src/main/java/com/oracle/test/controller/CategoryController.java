package com.oracle.test.controller;

import com.oracle.test.service.CategoryService;
import com.oracle.test.service.InitService;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public String openCategory(Model model, @PathVariable Long id){
        model.addAttribute("category", categoryService.findCategoryWithSubCategories(id));
        return "category";
    }

}

