package hello_1.core;

import hello_1.core.member.Grade;
import hello_1.core.member.Member;
import hello_1.core.member.MemberService;
import hello_1.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); //회원 가입이 되어야 됨

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
//회원 도메인 - 회원 가입 main