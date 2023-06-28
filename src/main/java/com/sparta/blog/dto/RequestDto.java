package com.sparta.blog.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestDto {
    private String username;
    private String contents;
    private String password;
    private LocalDateTime date;
    private String title;
}
