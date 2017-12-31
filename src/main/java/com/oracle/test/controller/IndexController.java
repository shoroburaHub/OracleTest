package com.oracle.test.controller;

import com.oracle.test.entity.User;
import com.oracle.test.misc.PrepReader;
import com.oracle.test.service.DataStore;
import com.oracle.test.service.DbDataStore;
import com.oracle.test.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by admin on 12/27/2017.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
