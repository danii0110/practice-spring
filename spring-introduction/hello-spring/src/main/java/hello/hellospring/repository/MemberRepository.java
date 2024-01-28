package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장소에 저장
    Optional<Member> findById(Long id); //저장소에서 id 찾아오기
    Optional<Member> findByName(String name); //저장소에서 name 찾아오기
    List<Member> findAll(); //지금까지 저장된 모든 회원 리스트를 다 반환
}
