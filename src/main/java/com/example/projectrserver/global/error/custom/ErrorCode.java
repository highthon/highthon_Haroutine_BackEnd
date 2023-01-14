package com.example.projectrserver.global.error.custom;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    TIME_NOT_MATCH(400, "time-400-1", "시간 단위가 맞지 않습니다"),

    EXPIRED_JWT(401, "jwt-401-1", "토큰 만료"),
    INVALID_JWT(401, "jwt-401-1", "토큰 인증 실패"),

    USER_NOT_FOUND(404, "user-404-1", "유저를 찾지 못함"),
    ROUTINE_NOT_FOUND(404, "routine-404-1", "루틴을 찾지 못함"),

    LIKE_CONFLICT(409, "routine-409-1", "루틴 좋아요 중복"),
    USER_CONFLICT(409, "user-409-1", "유저 네임 중복"),

    INTERNAL_SERVER_ERROR(500, "server-1", "서버에러");

    private final int status;
    private final String code;
    private final String message;
}