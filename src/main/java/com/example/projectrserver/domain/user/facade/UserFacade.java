package com.example.projectrserver.domain.user.facade;

import com.example.projectrserver.domain.user.domain.User;
import com.example.projectrserver.domain.user.domain.repository.UserRepository;
import com.example.projectrserver.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByName(name)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}