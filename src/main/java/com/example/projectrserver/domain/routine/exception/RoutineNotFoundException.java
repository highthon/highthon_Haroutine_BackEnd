package com.example.projectrserver.domain.routine.exception;

import com.example.projectrserver.global.error.custom.CustomException;
import com.example.projectrserver.global.error.custom.ErrorCode;

public class RoutineNotFoundException extends CustomException {
    public static final RoutineNotFoundException EXCEPTION =
            new RoutineNotFoundException();

    public RoutineNotFoundException() {
        super(ErrorCode.ROUTINE_NOT_FOUND);
    }
}