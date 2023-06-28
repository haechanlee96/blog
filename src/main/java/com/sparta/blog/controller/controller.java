package com.sparta.blog.controller;


import com.sparta.blog.Entity.Post;
import com.sparta.blog.dto.RequestDto;
import com.sparta.blog.dto.ResponseDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/posts") // 전체 조회
    public List<ResponseDto> getPost(){
        // responsedto를 리스트로 만들어 그 모든값을 반환
        List<ResponseDto> reponseList = postList.values().stream()
                .map(ResponseDto::new).toList();
        return reponseList;
    }

    @GetMapping("/post/{id}")
    public ResponseDto selectList(@PathVariable Long id){
        // 해당 메모가 있는지 확인
        if(postList.containsKey(id)){
            Post post = postList.get(id);

            return new ResponseDto(post);
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    @PutMapping("/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody RequestDto requestDto){
        if(postList.containsKey(id)){
            Post post = postList.get(id);
            if(post.getPassword() == requestDto.getPassword()){ // 비밀번호는 숫자형으로만 일단 구성
               //수정 메서드를 추가
                post.update(requestDto);

                return post.getId();
            } else{
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }

    }

    @DeleteMapping("/post/{id}")
    public Long delete(@PathVariable Long id, @RequestBody RequestDto requestDto){
        if(postList.containsKey(id)){
            Post post = postList.get(id);
            if(post.getPassword() == requestDto.getPassword()){
              //삭제
                postList.remove(id);
                return id;
            } else {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

}
