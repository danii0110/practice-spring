package com.dan.springbootwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

//Posts 클래스로 DB에 접근하게 해주는 인터페이스
//JpaRepository<Entity 클래스, PK 타입>
//JpaRepository는 Spring Data JPA에서 제공하는 인터페이스 중 하나로, 기본적인 CRUD 작업을 자동으로 처리해줌