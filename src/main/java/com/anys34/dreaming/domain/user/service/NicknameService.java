package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NicknameService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(String nickname) {
        User user = userFacade.getCurrentUser();
        user.updateNickname(nickname);
    }
}
