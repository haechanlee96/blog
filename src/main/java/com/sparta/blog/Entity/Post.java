package com.sparta.blog.Entity;


import com.sparta.blog.dto.RequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private Long id;
    private String username;
    private String contents;


    public Post(RequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();

    }
}
