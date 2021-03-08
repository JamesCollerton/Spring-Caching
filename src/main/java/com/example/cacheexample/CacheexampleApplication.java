package com.example.cacheexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.cacheexample")
public class CacheexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheexampleApplication.class, args);
	}

}
