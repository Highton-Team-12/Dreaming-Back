package com.anys34.dreaming.domain.user.presentation;

import com.anys34.dreaming.domain.user.presentation.dto.req.*;
import com.anys34.dreaming.domain.user.presentation.dto.res.TokenResponse;
import com.anys34.dreaming.domain.user.presentation.dto.res.UserInfoResponse;
import com.anys34.dreaming.domain.user.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final LoginService loginService;
    private final SignupService signupService;
    private final EmailDuplicationService emailDuplicationService;
    private final UserInfoService userInfoService;
    private final GoalService goalService;
    private final DayService dayService;
    private final ProfileImgUpdateService profileImgUpdateService;

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

    @PostMapping("/goal")
    public void goal(@RequestBody @Valid GoalRequest goalRequest) {
        goalService.execute(goalRequest.getGoal());
    }

    @PostMapping("/day")
    public void day(@RequestBody DayGoalRequest dayGoalRequest) {
        dayService.execute(dayGoalRequest);
    }

    @PostMapping("/img")
    public void img(@RequestPart MultipartFile file) {
        profileImgUpdateService.execute(file);
    }
}
