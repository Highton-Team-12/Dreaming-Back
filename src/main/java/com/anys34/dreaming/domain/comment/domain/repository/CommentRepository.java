package com.anys34.dreaming.domain.comment.domain.repository;

import com.anys34.dreaming.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
