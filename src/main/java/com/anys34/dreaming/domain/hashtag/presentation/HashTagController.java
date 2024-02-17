package com.anys34.dreaming.domain.hashtag.presentation;

import com.anys34.dreaming.domain.hashtag.presentation.dto.req.HashTagsRequest;
import com.anys34.dreaming.domain.hashtag.presentation.dto.res.HashTagsResponse;
import com.anys34.dreaming.domain.hashtag.service.HashTagsSelectService;
import com.anys34.dreaming.domain.hashtag.service.HashTagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hashtag")
@RestController
public class HashTagController {
    private final HashTagsService hashTagsService;
    private final HashTagsSelectService hashTagsSelectService;

    @GetMapping
    public List<HashTagsResponse> hashTags() {
        return hashTagsService.execute();
    }

    @PostMapping("/upload")
    public void hashtag(@RequestBody HashTagsRequest hashTagsRequest) {
        hashTagsSelectService.execute(hashTagsRequest);
    }
}
