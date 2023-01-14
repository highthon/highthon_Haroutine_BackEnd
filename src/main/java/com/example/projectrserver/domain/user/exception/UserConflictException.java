package com.example.projectrserver.domain.user.exception;

import com.example.projectrserver.global.error.custom.CustomException;
import com.example.projectrserver.global.error.custom.ErrorCode;

public class UserConflictException extends CustomException {
    public static final UserConflictException EXCEPTION =
            new UserConflictException();

    public UserConflictException() {
        super(ErrorCode.USER_CONFLICT);
    }
}