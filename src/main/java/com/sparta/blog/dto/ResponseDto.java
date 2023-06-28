package com.sparta.blog.dto;

import com.sparta.blog.Entity.Post;
import lombok.Getter;

@Getter

public class ResponseDto {

    private Long id;
    private String username;
    private String contents;

    public ResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.contents = post.getContents();
    }
}
