package hello_1.core.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
//회원 서비스 인터페이스
//1. 회원 가입
//2. 회원 조회