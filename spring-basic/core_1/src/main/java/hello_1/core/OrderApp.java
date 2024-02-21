package hello_1.core;

import hello_1.core.member.Grade;
import hello_1.core.member.Member;
import hello_1.core.member.MemberService;
import hello_1.core.member.MemberServiceImpl;
import hello_1.core.order.Order;
import hello_1.core.order.OrderService;
import hello_1.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        //메모리 객체에 넣어놓기
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //System.out.println("order = " + order.toString());
        //System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
//이 코드처럼 main()이 아닌 자동화된 테스트가 필요함
//주문과 할인 정책 실행