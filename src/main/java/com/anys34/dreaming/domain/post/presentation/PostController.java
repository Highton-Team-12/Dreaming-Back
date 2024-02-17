package com.anys34.dreaming.domain.post.presentation;

import com.anys34.dreaming.domain.post.presentation.dto.req.UploadPostRequest;
import com.anys34.dreaming.domain.post.presentation.dto.res.PostResponse;
import com.anys34.dreaming.domain.post.presentation.dto.res.PostsListResponse;
import com.anys34.dreaming.domain.post.service.ListPostService;
import com.anys34.dreaming.domain.post.service.PostService;
import com.anys34.dreaming.domain.post.service.UploadPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {
    private final UploadPostService uploadPostService;
    private final ListPostService listPostService;
    private final PostService postService;

    @PostMapping
    public void upload(@RequestBody UploadPostRequest uploadPostRequest) {
        uploadPostService.execute(uploadPostRequest);
    }

    @GetMapping("/list")
    public List<PostsListResponse> list() {
        return listPostService.execute();
    }

    @GetMapping("/{id}")
    public PostResponse get(@PathVariable Long id) {
        return postService.execute(id);
    }
}
