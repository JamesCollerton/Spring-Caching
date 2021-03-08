package com.example.cacheexample.repository;

import com.example.cacheexample.model.User;
import com.example.cacheexample.repository.cache.UserCacheRepository;
import com.example.cacheexample.repository.db.UserDatabaseRepository;
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
    private UserDatabaseRepository userDatabaseRepository;

    @Autowired
    private UserCacheRepository userCacheRepository;

    private RedisTemplate<Long, User> redisTemplate;
    private HashOperations hashOperations;

    public UserDaoImpl(RedisTemplate<Long, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public User getUser(Long id) {

        log.info("Checking in cache for user with Id {}", id);

        Optional<User> userCacheOptional = userCacheRepository.findById(id);

        log.info("Retrieved cache result for user with Id {}", id);

        return userCacheOptional.orElseGet(() -> {

            log.info("No user with Id {} in cache", id);

            Optional<User> optionalUser = userDatabaseRepository.findById(id);

            log.info("Retrieved user with Id {} from database", id);

            User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

            log.info("Persisting user with Id {} to cache", id);

            User cacheUser = userCacheRepository.save(user);

            log.info("Persisted user with Id {} to cache", cacheUser.getId());

            return user;

        });

    }

    @Override
    public User createUser(User user) {

        log.info("Creating a new user in the database with name {}", user.getName());

        User newUser = userDatabaseRepository.save(user);

        log.info("Saved new user in the database Id {}, name {}", user.getId(), user.getName());

        userCacheRepository.save(newUser);

        log.info("Saved new user in the cache Id {}, name {}", user.getId());

        return newUser;
    }
}
