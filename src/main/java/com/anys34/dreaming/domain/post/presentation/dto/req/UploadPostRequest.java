package com.anys34.dreaming.domain.post.presentation.dto.req;

import com.anys34.dreaming.domain.post.domain.Post;
import com.anys34.dreaming.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UploadPostRequest {
    String title;
    String content;

    public Post toEntity(User user) {
        return Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}
