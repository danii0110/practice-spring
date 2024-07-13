package core.spring_basic_p1.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}