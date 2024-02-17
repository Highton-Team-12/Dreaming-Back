package com.anys34.dreaming.domain.post.domain.repository;

import com.anys34.dreaming.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
