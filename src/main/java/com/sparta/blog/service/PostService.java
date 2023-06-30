package com.sparta.blog.service;

import com.sparta.blog.Entity.Post;
import com.sparta.blog.dto.RequestDto;
import com.sparta.blog.dto.ResponseDto;
import com.sparta.blog.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public ResponseDto createPost(RequestDto requestDto){ //게시글 생성
        //RequestDto -> Entity
        Post post = new Post(requestDto);

        //DB save
        Post savePost = postRepository.save(post);

        //Entity->ResponseDto
        ResponseDto postResponseDto = new ResponseDto(savePost);

        return postResponseDto;
    }


    public ResponseDto getPost(Long id) { //게시글 선택 조회
        Post post = findPost(id);
        ResponseDto responseDto = new ResponseDto(post);
        return responseDto;
    }


    public List<ResponseDto> getPosts() { //게시글 전체 조회
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(ResponseDto::new).toList();
    }

    @Transactional
    public ResponseDto updatePost(Long id, RequestDto requestDto){ //게시글 수정
        // 해당 메모 DB에 존재 확인
        Post post = findPost(id);
        if(post.getPassword().equals(requestDto.getPassword())){
            post.update(requestDto);
            return new ResponseDto(post);
        } else {
            throw new IllegalArgumentException("비밀번호가 다릅니다.");
        }

    }

    public boolean deletePost(Long id, RequestDto requestDto) {
        // 해당 메모 DB에 존재 확인
        Post post = findPost(id);
        if(post.getPassword().equals(requestDto.getPassword())){
            postRepository.delete(post);
        } else {
            throw new IllegalArgumentException("비밀번호가 다릅니다.");
        }
        return true;

    }

    private Post findPost(Long id) { //게시글 찾는 메서드
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }


}
