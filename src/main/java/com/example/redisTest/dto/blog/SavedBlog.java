package com.example.redisTest.dto.blog;

import com.example.redisTest.domain.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedBlog {

    private String title;
    private String content;

    public Blog blog (SavedBlog savedBlog) {
        return Blog.of(savedBlog.getTitle(), savedBlog.content);
    }
}
