package com.example.cacheexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.cacheexample.repository.db")
@EnableRedisRepositories("com.example.cacheexample.repository.cache")
public class CacheexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheexampleApplication.class, args);
	}

}
