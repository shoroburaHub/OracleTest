package com.oracle.test.dao;

import com.oracle.test.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 12/30/2017.
 */
public interface CategoryDao extends JpaRepository<Category, Long> {
}
