package com.dan.springbootwebservice.web.dto;

import com.dan.springbootwebservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Long id, String title, String author, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.modifiedDate = modifiedDate;
    }
}

//게시물 목록을 조회할 때 클라이언트로부터 반환할 데이터의 형식을 정의하는 DTO(Data Transfer Object) 클래스