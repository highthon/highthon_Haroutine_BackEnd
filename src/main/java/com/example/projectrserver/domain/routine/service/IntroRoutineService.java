package com.example.projectrserver.domain.routine.service;

import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.routine.domain.repository.RoutineInfoRepository;
import com.example.projectrserver.domain.routine.domain.repository.RoutineRepository;
import com.example.projectrserver.domain.routine.facade.RoutineInfoFacade;
import com.example.projectrserver.domain.routine.present.dto.RoutineDto;
import com.example.projectrserver.domain.tag.domain.facade.TagFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IntroRoutineService {
    private final RoutineInfoFacade routineInfoFacade;
    private final RoutineInfoRepository routineInfoRepository;
    private final TagFacade tagFacade;

    @Transactional
    public RoutineDto getRoutine(Integer id) {
        Routine routine = routineInfoFacade.getRoutine(id);

        List<RoutineDto.RoutineList> routineLists = routineInfoRepository.findAllByRoutine(routine)
                .stream()
                .map(routineInfo -> RoutineDto.RoutineList.builder()
                        .title(routineInfo.getTitle())
                        .startTime(routineInfo.getStartTime())
                        .lastTime(routineInfo.getLastTime())
                        .build())
                .toList();

        return RoutineDto.builder()
                .intro(routine.getIntro())
                .content(routine.getContent())
                .title(routine.getTitle())
                .writer(routine.getUser().getName())
                .tags(tagFacade.getTagList(routine))
                .id(routine.getId())
                .routineInfo(routineLists)
                .build();
    }
}