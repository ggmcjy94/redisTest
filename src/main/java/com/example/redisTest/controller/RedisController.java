package com.example.redisTest.controller;

import com.example.redisTest.dto.RedisReqDto;
import com.example.redisTest.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RedisController {


    private final RedisService redisService;

    @PostMapping("/redis")
    public boolean create(@RequestBody RedisReqDto reqDto) {
        redisService.setRedisValue(reqDto.getKey(), reqDto.getValue());
        return true;
    }


    @GetMapping("/redis")
    public String read (@RequestParam String key) {
        return redisService.getRedisValue(key);
    }

    @PutMapping("/redis")
    public boolean update(@RequestBody RedisReqDto reqDto) {
        redisService.updateRedisValue(reqDto.getKey(), reqDto.getValue());
        return true;
    }

    @DeleteMapping("/redis")
    public boolean delete(@RequestBody RedisReqDto reqDto) {
        redisService.deleteRedisValue(reqDto.getKey());
        return true;
    }

}
