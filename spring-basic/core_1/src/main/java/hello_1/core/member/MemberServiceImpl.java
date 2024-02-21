package hello_1.core.member;

public class MemberServiceImpl implements MemberService{

    //가입을 하고 회원을 찾으려면 MemberRepository가 필요
    //아래의 코드는 DIP 위반(MemberServiceImpl이 두 개를 참조하고 있기 때문에)
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository; //뒷부분 지우고 생성자 만들기

    //MemberRepository에 무엇이 들어갈지를 생성자를 통해서 만들어줌
    public MemberServiceImpl(MemberRepository memberRepository) { //새로 만든 생성자
        this.memberRepository = memberRepository;
    } //결국 이 파일에는 MemoryMemberRepository의 코드는 없게 되고, MemberRepository에 대한 인터페이스만 존재하게 된다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
//회원 서비스 구현체
