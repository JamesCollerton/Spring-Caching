# Spring Caching

A small example of using Redis caching with Spring. It was developed as part of a Medium article found [here](https://medium.com/nerd-for-tech/getting-that-cache-money-1f93aea4f6ef). An outline of the system can be found below. It is written in [Spring Boot](https://spring.io/projects/spring-boot), using [H2](https://www.h2database.com/html/main.html) and [Spring Data Redis](https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/), with a [Redis](https://redis.io/) instance running locally.

![image](https://user-images.githubusercontent.com/8677801/113471854-1593b780-9457-11eb-9b30-06b152ee42c8.png)

The application demonstrates two methods of caching:
- *Lazy Loading:* When we retrieve a user from the database they are also written to the cache.
- *Write Through:* When we write a user to the database they are also written to the cache.
