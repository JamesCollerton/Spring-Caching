package com.example.cacheexample.repository.db;

import com.example.cacheexample.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDatabaseRepository extends CrudRepository<User, Long> {
}
