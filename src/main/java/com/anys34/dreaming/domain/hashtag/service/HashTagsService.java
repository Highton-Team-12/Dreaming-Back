package com.anys34.dreaming.domain.hashtag.service;

import com.anys34.dreaming.domain.hashtag.domain.repository.HashtagRepository;
import com.anys34.dreaming.domain.hashtag.presentation.dto.res.HashTagsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HashTagsService {
    private final HashtagRepository hashtagRepository;

    @Transactional(readOnly = true)
    public List<HashTagsResponse> execute() {
        return hashtagRepository.findAll().stream()
                .map(HashTagsResponse::new)
                .collect(Collectors.toList());
    }
}
