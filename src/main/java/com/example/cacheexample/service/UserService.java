package com.example.cacheexample.service;

import com.example.cacheexample.model.User;
import com.example.cacheexample.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /*
        Lazy Loading
     */
    public User getUser(String id) {

        // Check in cache

        userDao.findAll();
        return null;
    }

    /*
        Write through
     */
    public User createUser(User user) {
        return null;
    }
}
