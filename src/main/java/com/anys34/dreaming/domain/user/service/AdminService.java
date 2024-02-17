package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.User;
import com.anys34.dreaming.domain.user.exception.AdminNotException;
import com.anys34.dreaming.domain.user.exception.UserIncorrectException;
import com.anys34.dreaming.domain.user.facade.UserFacade;
import com.anys34.dreaming.domain.user.presentation.dto.req.LoginRequest;
import com.anys34.dreaming.domain.user.presentation.dto.res.TokenResponse;
import com.anys34.dreaming.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public TokenResponse execute(LoginRequest loginRequest) {
        User user = userFacade.getUserByEmail(loginRequest.getEmail());

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw UserIncorrectException.EXCEPTION;
        }

        if (!user.getAdmin()) {
            throw AdminNotException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(loginRequest.getEmail()))
                .build();
    }
}
