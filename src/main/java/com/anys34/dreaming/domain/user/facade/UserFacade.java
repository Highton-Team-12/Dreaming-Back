package com.anys34.dreaming.domain.user.facade;

import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.domain.repository.UserRepository;
import com.anys34.dreaming.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
@Configuration
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
