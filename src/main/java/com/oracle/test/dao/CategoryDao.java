package com.oracle.test.dao;

import com.oracle.test.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by admin on 12/30/2017.
 */
public interface CategoryDao extends JpaRepository<Category, Long> {
    @Query("select c from Category c left join fetch c.subcategorys where c.id = ?1")
    Category findCategoryWithSubCategories(Long id);
}
