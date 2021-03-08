package com.example.cacheexample.repository;

import com.example.cacheexample.model.User;

public interface UserDao {
    User getUser(Long id);
    User createUser(User user);
}
