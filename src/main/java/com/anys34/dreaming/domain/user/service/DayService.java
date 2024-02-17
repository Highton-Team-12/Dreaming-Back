package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import com.anys34.dreaming.domain.user.presentation.dto.req.DayGoalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DayService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(DayGoalRequest dayGoalRequest) {
        User user = userFacade.getCurrentUser();
        if (dayGoalRequest.getId() == 1) {
            user.updateWeek(dayGoalRequest.getContent());
        } if (dayGoalRequest.getId() == 2) {
            user.updateMonth(dayGoalRequest.getContent());
        } if (dayGoalRequest.getId() == 3) {
            user.updateYear(dayGoalRequest.getContent());
        }
    }
}
