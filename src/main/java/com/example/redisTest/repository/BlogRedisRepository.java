package com.example.redisTest.repository;

import com.example.redisTest.dto.blog.BlogResponseDto;
import org.springframework.data.repository.CrudRepository;

public interface BlogRedisRepository extends CrudRepository<BlogResponseDto, String> {
}
