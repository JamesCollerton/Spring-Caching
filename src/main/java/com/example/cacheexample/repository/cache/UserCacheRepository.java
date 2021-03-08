package com.example.cacheexample.repository.cache;

import com.example.cacheexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCacheRepository extends CrudRepository<User, Long> {
}
