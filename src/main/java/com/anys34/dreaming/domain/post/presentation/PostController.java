package com.anys34.dreaming.domain.post.presentation;

import com.anys34.dreaming.domain.post.presentation.dto.req.UploadPostRequest;
import com.anys34.dreaming.domain.post.service.UploadPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {
    private final UploadPostService uploadPostService;

    @PostMapping
    public void upload(@RequestBody UploadPostRequest uploadPostRequest) {
        uploadPostService.execute(uploadPostRequest);
    }
}
