package com.example.projectrserver.domain.like.present;

import com.example.projectrserver.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/routines/like")
@RequiredArgsConstructor
@RestController
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLike(@PathVariable("id") Integer id) {
        likeService.addLike(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLike(@PathVariable("id") Integer id) {
        likeService.deleteLike(id);
    }
}