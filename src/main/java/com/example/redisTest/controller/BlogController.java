package com.example.redisTest.controller;

import com.example.redisTest.dto.blog.BlogResponseDto;
import com.example.redisTest.dto.blog.SavedBlog;
import com.example.redisTest.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping
    public boolean saveBlog(@RequestBody SavedBlog saveBlog) {
        blogService.save(saveBlog);
        return true;
    }

    @GetMapping("/{title}")
    public BlogResponseDto blogResponseDto(@PathVariable("title") String title) {

        long startTime = System.currentTimeMillis();
        BlogResponseDto blogResponseDto = blogService.getBlogResponseDto(title);
        long endTime = System.currentTimeMillis();
        log.info("[content] response Time : {}ms", (endTime - startTime));
        return blogResponseDto;
    }

}
