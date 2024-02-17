package com.anys34.dreaming.domain.user.exception;

import com.anys34.dreaming.global.config.error.exception.BusinessException;
import com.anys34.dreaming.global.config.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {super(ErrorCode.USER_NOT_FOUND);}
}
