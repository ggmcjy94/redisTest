package com.example.redisTest.repository;

import com.example.redisTest.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Blog findByTitle(String title);
}
