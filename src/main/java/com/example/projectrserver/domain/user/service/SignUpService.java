package com.example.projectrserver.domain.user.service;

import com.example.projectrserver.domain.user.domain.User;
import com.example.projectrserver.domain.user.domain.repository.UserRepository;
import com.example.projectrserver.domain.user.exception.UserConflictException;
import com.example.projectrserver.domain.user.exception.UserNotFoundException;
import com.example.projectrserver.domain.user.present.dto.SignUpDto;
import com.example.projectrserver.domain.user.present.dto.TokenResponse;
import com.example.projectrserver.global.security.jwt.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse signup(SignUpDto request) {

        if (userRepository.findByName(request.getName()).isPresent()) {
            throw UserConflictException.EXCEPTION;
        }

        User user = userRepository.save(
                User.builder()
                        .name(request.getName())
                        .build()
        );

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getName()))
                .build();
    }
}