package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest { //굳이 public으로 안해도 됨
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring"); //단축키 : command + shift + enter => 밑으로 내려가기

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //optional에서 값을 꺼낼 때는 get 사용해서 꺼낼 수 있음
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //단축키 : command + option + v : 자동완성

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll(); //단축키 : command + option + v : 자동완성

        assertThat(result.size()).isEqualTo(2);
    }
}
//테스트는 서로 순서와 관계없이 서로 의존관계 없이 설계가 되어야 된다.
//그러기 위해선 하나의 테스트가 끝날 때마다 저장소가 공용 데이터들을 다시 깔끔하게 지워주어야 된다.