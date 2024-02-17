package com.anys34.dreaming.global.config.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_DUPLICATE(HttpStatus.BAD_REQUEST, "User Duplicate"), // 유저의 이메일이 중복됨
    USER_INCORRECT(HttpStatus.BAD_REQUEST, "User Incorrect"), // 이메일 혹은 비밀번호가 맞지 않음
    UNEXPECTED_TOKEN(HttpStatus.BAD_REQUEST, "Unexpected token"),
    ADMIN_NOT(HttpStatus.BAD_REQUEST, "Not Admin"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post Not Found"),

    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "Expired Jwt"), // 만료된 JWT

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found"), // 유저를 찾을 수 없음

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus status;
    private final String message;
}
