package com.anys34.dreaming.domain.post.service;

import com.anys34.dreaming.domain.post.domain.repository.PostRepository;
import com.anys34.dreaming.domain.post.presentation.dto.res.PostsListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ListPostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostsListResponse> execute() {
        return postRepository.findAll().stream()
                .map(PostsListResponse::new)
                .collect(Collectors.toList());
    }
}
