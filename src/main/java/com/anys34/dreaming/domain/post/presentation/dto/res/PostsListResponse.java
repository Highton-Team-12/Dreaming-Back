package com.anys34.dreaming.domain.post.presentation.dto.res;

import com.anys34.dreaming.domain.post.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsListResponse {
    Long id;
    String title;

    public PostsListResponse(Post post) {
        id = post.getId();
        title = post.getTitle();
    }
}
