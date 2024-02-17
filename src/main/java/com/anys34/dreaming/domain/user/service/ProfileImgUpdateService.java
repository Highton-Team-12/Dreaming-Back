package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import com.anys34.dreaming.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ProfileImgUpdateService {
    private final S3Service s3Service;
    private final UserFacade userFacade;

    @Transactional
    public void execute(MultipartFile file) {
        User user = userFacade.getCurrentUser();
        String url = s3Service.uploadFile(file, user.getNickname());

        user.updateImg(url);
    }
}
