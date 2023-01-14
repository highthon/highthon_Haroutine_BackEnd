package com.example.projectrserver.domain.like.domain.repository;

import com.example.projectrserver.domain.like.domain.Like;
import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    Optional<Like> findByUserAndRoutine(User user, Routine routine);

    Integer countLikeByRoutine(Routine routine);
}