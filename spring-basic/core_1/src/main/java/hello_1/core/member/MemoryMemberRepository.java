package hello_1.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //key, value
    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //넣어줌
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //찾아옴
    }
}
//회원 저장
//메모리 회원 저장소 구현체