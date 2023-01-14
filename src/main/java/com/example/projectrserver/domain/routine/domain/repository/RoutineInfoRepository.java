package com.example.projectrserver.domain.routine.domain.repository;

import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.routine.domain.RoutineInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoutineInfoRepository extends CrudRepository<RoutineInfo, Integer> {
    List<RoutineInfo> findAllByRoutine(Routine routine);
}