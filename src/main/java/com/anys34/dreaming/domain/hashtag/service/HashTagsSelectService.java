package com.anys34.dreaming.domain.hashtag.service;

import com.anys34.dreaming.domain.hashtag.domain.Hashtag;
import com.anys34.dreaming.domain.hashtag.domain.repository.HashtagRepository;
import com.anys34.dreaming.domain.hashtag.presentation.dto.req.HashTagsRequest;
import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HashTagsSelectService {
    private final HashtagRepository hashtagRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(HashTagsRequest hashTagsRequest) {
        List<Hashtag> hashtags = new ArrayList<>();
        for (String hashtagName : hashTagsRequest.getHashTags()) {
            Hashtag existingHashtag = hashtagRepository.findByName(hashtagName);
            hashtags.add(existingHashtag);
        }

        User user = userFacade.getCurrentUser();

        user.updateHashTags(hashtags);
    }
}
