package com.sparta.blog.controller;


import com.sparta.blog.Entity.Post;
import com.sparta.blog.dto.RequestDto;
import com.sparta.blog.dto.ResponseDto;
import com.sparta.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class PostController {


    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/post") //게시글 작성
    public ResponseDto createPost(@RequestBody RequestDto requestDto){
        return postService.createPost(requestDto);
    }

    @GetMapping("/posts") // 전체 조회
    public List<ResponseDto> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/post/{id}")
    public ResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody RequestDto requestDto){
        return postService.updatePost(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody RequestDto requestDto){
        return postService.deletePost(id);
    }

}
