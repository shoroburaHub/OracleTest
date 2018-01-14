package com.oracle.test.service;

import com.oracle.test.entity.TestHistory;

import java.util.List;

/**
 * Created by admin on 1/14/2018.
 */
public interface TestHistoryService {
   void save(TestHistory testHistory);
   List<TestHistory> findAll();
}
