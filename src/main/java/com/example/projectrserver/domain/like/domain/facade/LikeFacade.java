package com.example.projectrserver.domain.like.domain.facade;

import com.example.projectrserver.domain.like.domain.repository.LikeRepository;
import com.example.projectrserver.domain.routine.domain.Routine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LikeFacade {
    private final LikeRepository likeRepository;

    public Integer getLikes(Routine routine) {
        return likeRepository.countLikeByRoutine(routine);
    }
}