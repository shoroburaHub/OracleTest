package com.oracle.test.service;

import com.oracle.test.entity.Subcategory;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface SubCategoryService {
    void save(Subcategory subcategory);
    List<Subcategory> findAll();
}
