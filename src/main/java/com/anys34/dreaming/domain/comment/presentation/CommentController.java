package com.anys34.dreaming.domain.comment.presentation;

import com.anys34.dreaming.domain.comment.presentation.dto.req.CommentRequest;
import com.anys34.dreaming.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public void comment(@RequestBody CommentRequest commentRequest) {
        commentService.execute(commentRequest);
    }
}
