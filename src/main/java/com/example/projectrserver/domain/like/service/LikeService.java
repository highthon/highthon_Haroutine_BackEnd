package com.example.projectrserver.domain.like.service;

import com.example.projectrserver.domain.like.domain.Like;
import com.example.projectrserver.domain.like.domain.repository.LikeRepository;
import com.example.projectrserver.domain.like.exception.LikeConflictException;
import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.routine.domain.repository.RoutineRepository;
import com.example.projectrserver.domain.routine.exception.RoutineNotFoundException;
import com.example.projectrserver.domain.user.domain.User;
import com.example.projectrserver.domain.user.facade.UserFacade;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final RoutineRepository routineRepository;
    private final UserFacade userFacade;

    @Transactional
    public void addLike(Integer id) {
        User user = userFacade.getCurrentUser();

        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> RoutineNotFoundException.EXCEPTION);

        if (likeRepository.findByUserAndRoutine(user, routine).isPresent()) {
            throw LikeConflictException.EXCEPTION;
        }

        likeRepository.save(
                Like.builder()
                        .routine(routine)
                        .user(user)
                        .build()
        );
    }

    @Transactional
    public void deleteLike(Integer id) {
        User user = userFacade.getCurrentUser();

        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> RoutineNotFoundException.EXCEPTION);

        if (likeRepository.findByUserAndRoutine(user, routine).isPresent()) {
            Like like = likeRepository.findByUserAndRoutine(user, routine)
                    .orElseThrow(() -> RoutineNotFoundException.EXCEPTION);
            likeRepository.delete(like);
        }
    }
}