package com.example.projectrserver.domain.routine.service;

import com.example.projectrserver.domain.like.domain.facade.LikeFacade;
import com.example.projectrserver.domain.like.domain.repository.LikeRepository;
import com.example.projectrserver.domain.routine.domain.repository.RoutineRepository;
import com.example.projectrserver.domain.routine.facade.RoutineInfoFacade;
import com.example.projectrserver.domain.routine.present.dto.RoutineListDto;
import com.example.projectrserver.domain.tag.domain.facade.TagFacade;
import com.example.projectrserver.domain.user.domain.User;
import com.example.projectrserver.domain.user.facade.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoutineListService {
    private final RoutineRepository routineRepository;
    private final TagFacade tagFacade;
    private final RoutineInfoFacade routineInfoFacade;
    private final LikeRepository likeRepository;
    private final UserFacade userFacade;
    private final LikeFacade likeFacade;

    @Transactional
    public RoutineListDto RoutineList() {
        User user = userFacade.getCurrentUser();

        List<RoutineListDto.RoutineList> routineList = routineRepository.findAll()
                .stream()
                .map(routine -> RoutineListDto.RoutineList.builder()
                        .title(routine.getTitle())
                        .id(routine.getId())
                        .tags(tagFacade.getTagList(routine))
                        .content(routine.getContent())
                        .writer(routine.getUser().getName())
                        .likes(likeFacade.getLikes(routine))
                        .startTime(routineInfoFacade.getTime(routine).getStartTime())
                        .lastTime(routineInfoFacade.getTime(routine).getLastTime())
                        .isLike(likeRepository.findByUserAndRoutine(user, routine).isPresent())
                        .build())
                .collect(Collectors.toList());

        return RoutineListDto.builder()
                .routineList(routineList)
                .build();
    }
}