package com.anys34.dreaming.domain.post.service;

import com.anys34.dreaming.domain.comment.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentResponse {
    String comment;
    String nickname;

    public CommentResponse(Comment comment) {
        this.comment = comment.getText();
        this.nickname = comment.getUser().getNickname();
    }
}
