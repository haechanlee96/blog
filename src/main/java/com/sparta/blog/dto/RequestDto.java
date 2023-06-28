package com.sparta.blog.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestDto {
    private String author;
    private String contents;
    private int password;
    private LocalDateTime date;
    private String title;
}
