package com.sparta.blog.controller;


import com.sparta.blog.Entity.Post;
import com.sparta.blog.dto.RequestDto;
import com.sparta.blog.dto.ResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class controller {


    private final Map<Long, Post> postList = new HashMap<>();

    @PostMapping("/post") //게시글 작성
    public ResponseDto createPost(@RequestBody RequestDto requestDto){
        //request -> entity
        Post post = new Post(requestDto);

        // 중복되지 않는 id
        Long maxId = postList.size() > 0? Collections.max(postList.keySet())+1 : 1 ;

        // 필드 값의 id 변환
        post.setId(maxId);

        // 날짜 저장
        post.setDate(LocalDateTime.now());

        //db에 저장
        postList.put(post.getId(), post);

        // 변환되어 저장된 entity -> response
        ResponseDto responseDto = new ResponseDto(post);
        return responseDto;

    }


}
