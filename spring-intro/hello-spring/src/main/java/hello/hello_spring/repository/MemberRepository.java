package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional인 이유: null을 처리하기 위해서
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
