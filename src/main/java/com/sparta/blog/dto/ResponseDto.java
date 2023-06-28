package com.sparta.blog.dto;

import com.sparta.blog.Entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class ResponseDto {

    private Long id;
    private String author;
    private String contents;
    private int password;
    private LocalDateTime date;
    private String title;

    public ResponseDto(Post post) {
        this.id = post.getId();
        this.author = post.getAuthor();
        this.contents = post.getContents();
        this.title = post.getTitle();
        this.date = post.getDate();
        this.password = post.getPassword();
    }
}
