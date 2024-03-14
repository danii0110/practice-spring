package com.dan.springbootwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}

//Posts 클래스로 DB에 접근하게 해주는 인터페이스
//paRepository<Entity 클래스, PK 타입>
//기본적인 CRUD 자동으로 생성