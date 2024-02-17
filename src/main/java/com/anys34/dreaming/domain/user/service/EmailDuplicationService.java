package com.anys34.dreaming.domain.user.service;

import com.anys34.dreaming.domain.user.domain.repository.UserRepository;
import com.anys34.dreaming.domain.user.exception.UserDuplicateException;
import com.anys34.dreaming.domain.user.presentation.dto.req.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailDuplicationService {
    private final UserRepository userRepository;

    public void execute(EmailRequest emailRequest) {
        if (userRepository.existsByEmail(emailRequest.getEmail())) {
            throw UserDuplicateException.EXCEPTION;
        }
    }
}
