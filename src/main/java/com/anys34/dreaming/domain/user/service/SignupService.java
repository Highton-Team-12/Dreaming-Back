package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.repository.UserRepository;
import com.anys34.dreaming.domain.user.presentation.dto.req.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignupRequest signupRequest) {
        signupRequest.passwordUpdate(passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(signupRequest.toEntity());
    }
}
