package com.anys34.dreaming.domain.user.exception;

import com.anys34.dreaming.global.config.error.exception.BusinessException;
import com.anys34.dreaming.global.config.error.exception.ErrorCode;

public class AdminNotException extends BusinessException {
    public static final BusinessException EXCEPTION =
            new AdminNotException();

    private AdminNotException() {super(ErrorCode.ADMIN_NOT);}
}
