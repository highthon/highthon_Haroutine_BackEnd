package com.example.projectrserver.domain.routine.present.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class RoutineTimeResponse {
    private LocalTime startTime;
    private LocalTime lastTime;
}