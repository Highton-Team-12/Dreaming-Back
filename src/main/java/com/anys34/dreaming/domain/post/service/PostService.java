package com.anys34.dreaming.domain.post.service;

import com.anys34.dreaming.domain.post.domain.Post;
import com.anys34.dreaming.domain.post.domain.repository.PostRepository;
import com.anys34.dreaming.domain.post.exception.PostNotFoundException;
import com.anys34.dreaming.domain.post.presentation.dto.res.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponse execute(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        return new PostResponse(post);
    }
}
