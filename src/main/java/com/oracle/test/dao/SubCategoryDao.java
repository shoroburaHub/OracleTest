package com.oracle.test.dao;

import com.oracle.test.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface SubCategoryDao extends JpaRepository<Subcategory, Long> {
    @Query("select s from Subcategory s where s.category.id = ?1")
    List<Subcategory> findAllByCategoryId(Long categoryId);
}
