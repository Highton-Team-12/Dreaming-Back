package com.anys34.dreaming.domain.hashtag.presentation;

import com.anys34.dreaming.domain.hashtag.presentation.dto.res.HashTagsResponse;
import com.anys34.dreaming.domain.hashtag.service.HashTagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hashtag")
@RestController
public class HashTagController {
    private final HashTagsService hashTagsService;

    @GetMapping
    public List<HashTagsResponse> hashTags() {
        return hashTagsService.execute();
    }
}
