package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repo = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { // 메서드가 실행이 끝날 때마다 어떤 동작을 하는 것
        repo.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repo.save(member);

        Member res = repo.findById(member.getId()).get();
//        Assertions.assertEquals(member, res);
        assertThat(member).isEqualTo(res);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        Member res = repo.findByName("spring1").get();
        assertThat(res).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repo.save(member2);

        List<Member> res = repo.findAll();
        assertThat(res.size()).isEqualTo(2);
    }
}