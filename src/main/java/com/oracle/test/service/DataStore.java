package com.oracle.test.service;

import com.oracle.test.entity.*;

import java.util.List;

public interface DataStore {

    int allCategoriesCount();

    List<Question> allQuestions();

    List<User> allUsers();

    List<Category> findAllCategory();

    List<Question> findQuestions(final Subcategory cat);

    User getUser(final String username);

    <T extends BaseEntity> void persist(final T entity);

    public void flush();

}
