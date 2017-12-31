package com.oracle.test.dao;

import com.oracle.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 12/30/2017.
 */
public interface UserDao extends JpaRepository<User, Long> {
}
