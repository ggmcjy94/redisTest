package com.example.redisTest.service;

import com.example.redisTest.domain.Blog;
import com.example.redisTest.dto.blog.BlogResponseDto;
import com.example.redisTest.dto.blog.SavedBlog;
import com.example.redisTest.repository.BlogRedisRepository;
import com.example.redisTest.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final BlogRedisRepository blogRedisRepository;

    public void save(SavedBlog saveBlog) {
        blogRepository.save(saveBlog.blog(saveBlog));
        //cache logic
        BlogResponseDto blogResponseDto = new BlogResponseDto(saveBlog.getTitle(), saveBlog.getContent());
        blogRedisRepository.save(blogResponseDto);
    }

    public BlogResponseDto getBlogResponseDto(String title) {
        Optional<BlogResponseDto> foundResponseDto = blogRedisRepository.findById(title);
        if (foundResponseDto.isPresent()) {
            log.info("yes data");
            return foundResponseDto.get();
        } else {
            log.info("no data");
        }
        Blog blog = blogRepository.findByTitle(title);
        return new BlogResponseDto(blog.getTitle(), blog.getContent());
    }
}
