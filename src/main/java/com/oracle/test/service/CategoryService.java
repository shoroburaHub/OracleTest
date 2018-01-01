package com.oracle.test.service;

import com.oracle.test.entity.Category;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface CategoryService {

    void save(Category category);
    List<Category> findAll();

    Category findCategoryWithSubCategories(Long id);
}
