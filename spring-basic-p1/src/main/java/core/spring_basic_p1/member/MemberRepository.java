package core.spring_basic_p1.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}