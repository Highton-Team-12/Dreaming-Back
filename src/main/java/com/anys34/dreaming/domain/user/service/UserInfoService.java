package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import com.anys34.dreaming.domain.user.presentation.dto.res.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserFacade userFacade;

    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();
        return new UserInfoResponse(user);
    }
}
