package core.spring_basic_p1;

import core.spring_basic_p1.discount.DiscountPolicy;
import core.spring_basic_p1.discount.FixDiscountPolicy;
import core.spring_basic_p1.discount.RateDiscountPolicy;
import core.spring_basic_p1.member.MemberRepository;
import core.spring_basic_p1.member.MemberService;
import core.spring_basic_p1.member.MemberServiceImpl;
import core.spring_basic_p1.member.MemoryMemberRepository;
import core.spring_basic_p1.order.OrderService;
import core.spring_basic_p1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
//애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.