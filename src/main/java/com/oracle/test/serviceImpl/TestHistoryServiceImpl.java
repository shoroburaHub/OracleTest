package com.oracle.test.serviceImpl;

import com.oracle.test.dao.TestHistoryDao;
import com.oracle.test.entity.TestHistory;
import com.oracle.test.service.TestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 1/14/2018.
 */
@Service
public class TestHistoryServiceImpl implements TestHistoryService{

    @Autowired
    private TestHistoryDao testHistoryDao;

    @Override
    public void save(TestHistory testHistory) {
        testHistoryDao.save(testHistory);
    }

    @Override
    public List<TestHistory> findAll() {
        return testHistoryDao.findAll();
    }
}
