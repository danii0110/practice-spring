package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //단축키 : ;이 안들어간 상태에서 ;도 함께 추가 : command + shift + enter
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) { //메모리에 구현체가 무엇이 들어갈 지를 생성자를 통해서 정함
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
