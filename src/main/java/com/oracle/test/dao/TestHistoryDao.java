package com.oracle.test.dao;

import com.oracle.test.entity.TestHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 1/14/2018.
 */
public interface TestHistoryDao extends JpaRepository<TestHistory, Long> {
}
