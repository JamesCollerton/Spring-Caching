package com.example.cacheexample.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
@RedisHash(value = "User", timeToLive = 5)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

}
