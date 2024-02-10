package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //단축키 : ;이 안들어간 상태에서 ;도 함께 추가 : command + shift + enter
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
