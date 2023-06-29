package com.sparta.blog.Entity;


import com.sparta.blog.dto.RequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post extends Timestamped {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "author", nullable = false)
    private String author;

    @Column (name = "contents", nullable = false)
    private String contents;

    @Column (name = "password", nullable = false)
    private int password;

    @Column (name = "title", nullable = false)
    private String title;


    public Post(RequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
    }

    public void update(RequestDto requestDto) {
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
