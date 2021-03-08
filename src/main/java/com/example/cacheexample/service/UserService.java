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

    public User createUser(User user) {
        log.info("Calling DAO to persist new user with name {}", user.getName());
        return userDao.createUser(user);
    }
}
