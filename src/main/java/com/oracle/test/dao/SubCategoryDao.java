package com.oracle.test.dao;

import com.oracle.test.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 12/30/2017.
 */
public interface SubCategoryDao extends JpaRepository<Subcategory, Long> {
}
