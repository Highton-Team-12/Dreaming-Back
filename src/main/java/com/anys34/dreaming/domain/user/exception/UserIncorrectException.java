package com.anys34.dreaming.domain.user.exception;

import com.anys34.dreaming.global.config.error.exception.BusinessException;
import com.anys34.dreaming.global.config.error.exception.ErrorCode;

public class UserIncorrectException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new UserIncorrectException();

    private UserIncorrectException() {super(ErrorCode.USER_INCORRECT);}
}
