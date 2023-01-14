package com.example.projectrserver.domain.like.exception;

import com.example.projectrserver.global.error.custom.CustomException;
import com.example.projectrserver.global.error.custom.ErrorCode;

public class LikeConflictException extends CustomException {
    public static final LikeConflictException EXCEPTION =
            new LikeConflictException();

    public LikeConflictException() {
        super(ErrorCode.LIKE_CONFLICT);
    }
}