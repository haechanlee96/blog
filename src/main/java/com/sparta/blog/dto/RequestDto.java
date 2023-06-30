package com.sparta.blog.dto;

import com.sparta.blog.Entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestDto {
    private String author;
    private String contents;
    private String password;
    private String title;

}
