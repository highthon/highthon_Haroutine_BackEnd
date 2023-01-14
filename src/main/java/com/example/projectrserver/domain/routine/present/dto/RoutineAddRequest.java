package com.example.projectrserver.domain.routine.present.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class RoutineAddRequest {
    private String title;
    private String content;
    private String intro;
    private List<String> tags;
    private List<RequestDto> routineInfo;

    @Getter
    @Builder
    public static class RequestDto {
        private String title;

        private String startTime;

        private String lastTime;

        public RequestDto(String title, String startTime, String lastTime) {
            this.title = title;
            this.startTime = startTime;
            this.lastTime = lastTime;
        }
    }
}