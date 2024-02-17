package com.anys34.dreaming.domain.user.exception;

import com.anys34.dreaming.global.config.error.exception.BusinessException;
import com.anys34.dreaming.global.config.error.exception.ErrorCode;

public class UserDuplicateException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new UserDuplicateException();

    private UserDuplicateException() {super(ErrorCode.USER_DUPLICATE);}
}
