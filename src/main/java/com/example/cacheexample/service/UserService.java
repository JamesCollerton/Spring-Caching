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

    public User getUser(String id) {
        log.info("Calling DAO to get user with Id {}", id);
        return userDao.getUser(Long.parseLong(id));
    }

    /*
        Write through
     */
    public User createUser(User user) {
        return userDao.createUser(user);
    }
}
