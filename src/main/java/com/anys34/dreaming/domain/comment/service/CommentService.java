package com.anys34.dreaming.domain.comment.service;

import com.anys34.dreaming.domain.comment.presentation.dto.req.CommentRequest;
import com.anys34.dreaming.domain.post.domain.Post;
import com.anys34.dreaming.domain.post.domain.repository.PostRepository;
import com.anys34.dreaming.domain.post.exception.PostNotFoundException;
import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CommentRequest commentRequest) {
        Post post = postRepository.findById(commentRequest.getId())
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        User user = userFacade.getCurrentUser();

        post.getComments().add(commentRequest.toEntity(post, user));
    }
}
