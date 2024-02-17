package com.anys34.dreaming.domain.comment.presentation.dto.req;

import com.anys34.dreaming.domain.comment.domain.Comment;
import com.anys34.dreaming.domain.post.domain.Post;
import com.anys34.dreaming.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentRequest {
    Long id;
    String comment;

    public Comment toEntity(Post post, User user) {
        return Comment.builder()
                .post(post)
                .text(comment)
                .user(user)
                .build();
    }
}
