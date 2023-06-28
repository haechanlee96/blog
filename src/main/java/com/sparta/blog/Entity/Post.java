package com.sparta.blog.Entity;


import com.sparta.blog.dto.RequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private Long id;
    private String author;
    private String contents;
    private int password;
    private LocalDateTime date;
    private String title;


    public Post(RequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        System.out.println("비밀번호 확인" + requestDto.getPassword());
    }

    public void update(RequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}
