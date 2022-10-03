package com.sparta.blog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BlogRequestDto {
    private String title;
    private String writer;
    private String content;
    private String password;


    public BlogRequestDto(String title, String writer, String content, String password) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }
}