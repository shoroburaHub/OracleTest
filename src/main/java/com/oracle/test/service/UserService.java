package com.oracle.test.service;

import com.oracle.test.entity.User;

import java.util.List;

/**
 * Created by admin on 12/30/2017.
 */
public interface UserService {
    void save(User user);

    List<User> findAll();
}
