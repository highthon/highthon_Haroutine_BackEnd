package com.example.projectrserver.domain.user.present;

import com.example.projectrserver.domain.routine.present.dto.RoutineListDto;
import com.example.projectrserver.domain.user.present.dto.SignUpDto;
import com.example.projectrserver.domain.user.present.dto.TokenResponse;
import com.example.projectrserver.domain.user.service.MyPageService;
import com.example.projectrserver.domain.user.service.SignInService;
import com.example.projectrserver.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/v1/accounts")
@RestController
public class UserController {
    private final SignInService signInService;
    private final SignUpService signUpService;
    private final MyPageService myPageService;

    @PostMapping
    public TokenResponse signUp(@RequestBody SignUpDto request) {
        return signUpService.signup(request);
    }

    @PostMapping("/sign")
    public TokenResponse signIn(@RequestBody SignUpDto request) {
        return signInService.signIn(request);
    }

    @GetMapping
    public RoutineListDto myPage() {
        return myPageService.getMyRoutine();
    }
}