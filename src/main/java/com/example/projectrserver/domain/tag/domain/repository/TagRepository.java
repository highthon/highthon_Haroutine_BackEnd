package com.example.projectrserver.domain.tag.domain.repository;

import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.tag.domain.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Integer> {
    List<Tag> findAllByRoutine(Routine routine);
}