package com.example.projectrserver.domain.routine.exception;

import com.example.projectrserver.global.error.custom.CustomException;
import com.example.projectrserver.global.error.custom.ErrorCode;

public class TimeNotMatchException extends CustomException {
    public static final TimeNotMatchException EXCEPTION =
            new TimeNotMatchException();

    public TimeNotMatchException() {
        super(ErrorCode.TIME_NOT_MATCH);
    }
}