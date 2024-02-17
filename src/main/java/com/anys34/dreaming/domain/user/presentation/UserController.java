package com.anys34.dreaming.domain.user.presentation;

import com.anys34.dreaming.domain.user.presentation.dto.req.EmailRequest;
import com.anys34.dreaming.domain.user.presentation.dto.req.LoginRequest;
import com.anys34.dreaming.domain.user.presentation.dto.req.SignupRequest;
import com.anys34.dreaming.domain.user.presentation.dto.res.TokenResponse;
import com.anys34.dreaming.domain.user.presentation.dto.res.UserInfoResponse;
import com.anys34.dreaming.domain.user.service.EmailDuplicationService;
import com.anys34.dreaming.domain.user.service.LoginService;
import com.anys34.dreaming.domain.user.service.SignupService;
import com.anys34.dreaming.domain.user.service.UserInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final LoginService loginService;
    private final SignupService signupService;
    private final EmailDuplicationService emailDuplicationService;
    private final UserInfoService userInfoService;

    @GetMapping
    public UserInfoResponse profile() {
        return userInfoService.execute();
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return loginService.execute(loginRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid SignupRequest signUpRequest) {
        signupService.execute(signUpRequest);
    }

    @PostMapping("/email")
    public void checkEmail(@RequestBody @Valid EmailRequest emailRequest) {
        emailDuplicationService.execute(emailRequest);
    }
}
