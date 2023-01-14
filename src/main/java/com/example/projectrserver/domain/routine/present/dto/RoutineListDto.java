package com.example.projectrserver.domain.routine.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RoutineListDto {
    private List<RoutineList> routineList;

    @Getter
    @Builder
    public static class RoutineList {
        private Integer id;
        private String title;
        private String content;
        private List<String> tags;
        private String writer;
        private Integer likes;
        private LocalTime startTime;
        private LocalTime lastTime;

        private Boolean isLike;
    }
}