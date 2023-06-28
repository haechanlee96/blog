package com.sparta.blog.dto;

import com.sparta.blog.Entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class ResponseDto {

    private Long id;
    private String username;
    private String contents;
    private String password;
    private LocalDateTime date;
    private String title;

    public ResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.date = post.getDate();
    }
}
