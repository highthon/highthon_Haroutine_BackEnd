package com.example.projectrserver.domain.routine.present;

import com.example.projectrserver.domain.routine.present.dto.RoutineAddRequest;
import com.example.projectrserver.domain.routine.present.dto.RoutineDto;
import com.example.projectrserver.domain.routine.present.dto.RoutineListDto;
import com.example.projectrserver.domain.routine.service.IntroRoutineService;
import com.example.projectrserver.domain.routine.service.RoutineListService;
import com.example.projectrserver.domain.routine.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/routines")
public class RoutineController {

    private final RoutineService routineService;
    private final RoutineListService routineListService;
    private final IntroRoutineService introRoutineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRoutine(@RequestBody RoutineAddRequest request) {
        routineService.addRoutine(request);
    }

    @GetMapping
    public RoutineListDto getList() {
        return routineListService.RoutineList();
    }

    @GetMapping("/{id}")
    public RoutineDto getRoutine(@PathVariable("id") Integer id) {
        return introRoutineService.getRoutine(id);
    }
}