package com.example.redisTest.dto.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "content", timeToLive = 60)
public class BlogResponseDto implements Serializable {

    @Id
    private String title;

    private String content;



}
