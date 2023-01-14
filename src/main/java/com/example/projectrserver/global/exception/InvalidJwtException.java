package com.example.projectrserver.global.exception;

import com.example.projectrserver.global.error.custom.CustomException;
import com.example.projectrserver.global.error.custom.ErrorCode;

public class InvalidJwtException extends CustomException {
    public static final InvalidJwtException EXCEPTION =
            new InvalidJwtException();

    public InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}