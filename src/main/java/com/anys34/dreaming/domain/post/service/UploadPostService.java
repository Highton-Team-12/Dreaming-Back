package com.anys34.dreaming.domain.post.service;

import com.anys34.dreaming.domain.post.domain.repository.PostRepository;
import com.anys34.dreaming.domain.post.presentation.dto.req.UploadPostRequest;
import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UploadPostService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(UploadPostRequest uploadPostRequest) {
        User user = userFacade.getCurrentUser();
        postRepository.save(uploadPostRequest.toEntity(user));
    }
}
