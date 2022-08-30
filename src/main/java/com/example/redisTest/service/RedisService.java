package com.example.redisTest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final int LIMIT_TIME = 3 * 60; //3분

//    private final RedisTemplate<String, String> redisTemplate; 이걸로 사용 가눙
    private final StringRedisTemplate stringRedisTemplate;

    //create
    public void setRedisValue(String key, String value) {
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key, value);
//        stringStringValueOperations.set(key,value,LIMIT_TIME); // 저장 만료 시간

    }

    //read
    public String getRedisValue(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if (value == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return value;
    }


    //update
    public void updateRedisValue(String key, String value) {
        stringRedisTemplate.opsForValue().getAndSet(key, value);
    }

    //delete
    public void deleteRedisValue(String key) {
        stringRedisTemplate.delete(key);
    }
}
