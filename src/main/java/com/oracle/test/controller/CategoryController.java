package com.oracle.test.controller;

import com.oracle.test.service.InitService;
import com.oracle.test.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by admin on 12/30/2017.
 */
@Controller
public class CategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/oca")
    public String ocaCategory(Model model) {
        model.addAttribute("allSubCategories", subCategoryService.findAll());
        return "oca";
    }

}

