package hello_1.core;

import hello_1.core.discount.FixDiscountPolicy;
import hello_1.core.member.MemberService;
import hello_1.core.member.MemberServiceImpl;
import hello_1.core.member.MemoryMemberRepository;
import hello_1.core.order.OrderService;
import hello_1.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() { //MemberSerivceImpl안에서 MemberRepository, MemoryMemberRepository를 지정해주고 있음(수정해야 할 사항!)
        return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
//나의 애플리케이션 전체를 설정하고 구성한다는 뜻