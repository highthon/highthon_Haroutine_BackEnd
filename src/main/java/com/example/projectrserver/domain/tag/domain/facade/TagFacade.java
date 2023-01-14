package com.example.projectrserver.domain.tag.domain.facade;

import com.example.projectrserver.domain.routine.domain.Routine;
import com.example.projectrserver.domain.tag.domain.Tag;
import com.example.projectrserver.domain.tag.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class TagFacade {
    private final TagRepository tagRepository;

    public List<String> getTagList(Routine routine) {
        return tagRepository.findAllByRoutine(routine)
                .stream().map(Tag::getName)
                .collect(Collectors.toList());
    }
}