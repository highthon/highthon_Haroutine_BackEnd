package com.example.projectrserver.domain.routine.facade;

import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.routine.domain.repository.RoutineInfoRepository;
import com.example.projectrserver.domain.routine.domain.repository.RoutineRepository;
import com.example.projectrserver.domain.routine.exception.RoutineNotFoundException;
import com.example.projectrserver.domain.routine.present.dto.RoutineTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@RequiredArgsConstructor
@Component
public class RoutineInfoFacade {
    private final RoutineInfoRepository routineInfoRepository;
    private final RoutineRepository routineRepository;

    public RoutineTimeResponse getTime(Routine routine) {
        LocalTime start = routineInfoRepository.findAllByRoutine(routine).get(0).getStartTime();
        LocalTime last = routineInfoRepository.findAllByRoutine(routine).get(routineInfoRepository.findAllByRoutine(routine).size() - 1).getLastTime();

        return RoutineTimeResponse.builder()
                .startTime(start)
                .lastTime(last)
                .build();
    }

    public Routine getRoutine(Integer id) {
        return routineRepository.findById(id)
                .orElseThrow(() -> RoutineNotFoundException.EXCEPTION);
    }
}