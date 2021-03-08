package com.example.cacheexample.service;

import com.example.cacheexample.model.User;
import com.example.cacheexample.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /*
        Lazy Loading
     */
    public User getUser(String id) {
        return null;
    }

    /*
        Write through
     */
    public User createUser(User user) {
        return null;
    }
}
