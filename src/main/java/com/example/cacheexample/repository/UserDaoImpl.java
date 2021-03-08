package com.example.cacheexample.repository;

import com.example.cacheexample.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    private RedisTemplate<Long, User> redisTemplate;
    private HashOperations hashOperations;

    public UserDaoImpl(RedisTemplate<Long, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public User getUser(Long id) {

        log.info("Checking in cache for user with Id {}", id);

        User user = (User) hashOperations.get("USER",id);

        log.info("Retrieved cache result for user with Id {}", id);

        if(user == null) {

            log.info("No user with Id {} in cache", id);

            Optional<User> optionalUser = userRepository.findById(id);

            log.info("Retrieved user with Id {} from database", id);

            user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

            log.info("Persisting user with Id {} to cache", id);

            hashOperations.put("USER", user.getId(), user);

            log.info("Persisted user with Id {} to cache", id);
        } else {
            log.info("User with Id {} in cache", id);
        }

        return user;
    }

    @Override
    public User createUser(User user) {

        log.info("Creating a new user in the database {}", user.getId());

        User newUser =  userRepository.save(user);

        log.info("Saved new user in the database {}", user.getId());

        hashOperations.put("USER", user.getId(), newUser);

        log.info("Saved new user in the cache {}", user.getId());

        return newUser;
    }
}
