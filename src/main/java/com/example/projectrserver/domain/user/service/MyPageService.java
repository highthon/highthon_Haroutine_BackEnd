package com.example.projectrserver.domain.user.service;

import com.example.projectrserver.domain.like.domain.facade.LikeFacade;
import com.example.projectrserver.domain.routine.domain.repository.RoutineRepository;
import com.example.projectrserver.domain.routine.facade.RoutineInfoFacade;
import com.example.projectrserver.domain.routine.present.dto.RoutineListDto;
import com.example.projectrserver.domain.tag.domain.facade.TagFacade;
import com.example.projectrserver.domain.user.domain.User;
import com.example.projectrserver.domain.user.domain.repository.UserRepository;
import com.example.projectrserver.domain.user.facade.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MyPageService {
    private final UserFacade userFacade;
    private final RoutineRepository routineRepository;
    private final TagFacade tagFacade;
    private final LikeFacade likeFacade;
    private final RoutineInfoFacade routineInfoFacade;

    @Transactional
    public RoutineListDto getMyRoutine() {
        User user = userFacade.getCurrentUser();

        List<RoutineListDto.RoutineList> lists = routineRepository.findAllByUser(user)
                .stream()
                .map(routine -> RoutineListDto.RoutineList.builder()
                        .id(routine.getId())
                        .title(routine.getTitle())
                        .tags(tagFacade.getTagList(routine))
                        .content(routine.getContent())
                        .writer(routine.getUser().getName())
                        .likes(likeFacade.getLikes(routine))
                        .startTime(routineInfoFacade.getTime(routine).getStartTime())
                        .lastTime(routineInfoFacade.getTime(routine).getLastTime())
                        .build())
                .collect(Collectors.toList());

        return RoutineListDto.builder()
                .routineList(lists)
                .build();
    }
}