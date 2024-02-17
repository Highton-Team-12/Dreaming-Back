package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GoalService {
    private final UserFacade userFacade;

    @Transactional
    public void execute(String goal) {
        User user = userFacade.getCurrentUser();
        user.updateGoal(goal);
    }
}
