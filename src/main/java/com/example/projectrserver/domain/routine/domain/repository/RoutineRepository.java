package com.example.projectrserver.domain.routine.domain.repository;

import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoutineRepository extends CrudRepository<Routine, Integer> {
    Optional<Routine> findById(Integer id);

    List<Routine> findAll();

    List<Routine> findAllByUser(User user);
}