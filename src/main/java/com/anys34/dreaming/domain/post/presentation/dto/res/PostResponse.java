package com.anys34.dreaming.domain.post.presentation.dto.res;

import com.anys34.dreaming.domain.post.domain.Post;
import com.anys34.dreaming.domain.post.service.CommentResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class PostResponse {
    String title;
    String content;
    List<CommentResponse> comments;

    public PostResponse(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.comments = post.getComments().stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }
}
