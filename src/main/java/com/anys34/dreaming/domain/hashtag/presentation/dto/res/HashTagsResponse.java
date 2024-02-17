package com.anys34.dreaming.domain.hashtag.presentation.dto.res;

import com.anys34.dreaming.domain.hashtag.domain.Hashtag;
import lombok.Getter;

@Getter
public class HashTagsResponse {
    String hashtags;

    public HashTagsResponse(Hashtag hashtag) {
        this.hashtags = hashtag.getName();
    }
}
