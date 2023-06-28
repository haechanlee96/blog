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
    private String username;
    private String contents;
    private String password;
    private LocalDateTime date;
    private String title;


    public Post(RequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();

    }

}
