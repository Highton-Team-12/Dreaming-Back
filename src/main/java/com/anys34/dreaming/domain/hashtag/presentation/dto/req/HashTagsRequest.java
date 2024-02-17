package com.anys34.dreaming.domain.hashtag.presentation.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class HashTagsRequest {
    List<String> hashTags;
}
