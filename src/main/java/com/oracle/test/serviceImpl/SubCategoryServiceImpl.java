package com.oracle.test.serviceImpl;

import com.oracle.test.dao.SubCategoryDao;
import com.oracle.test.entity.Subcategory;
import com.oracle.test.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    private SubCategoryDao subCategoryDao;

    @Override
    public void save(Subcategory subcategory) {
        subCategoryDao.save(subcategory);
    }

    @Override
    public List<Subcategory> findAll() {
        return subCategoryDao.findAll();
    }
}
