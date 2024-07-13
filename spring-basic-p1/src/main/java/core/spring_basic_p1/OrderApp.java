package core.spring_basic_p1;

import core.spring_basic_p1.member.Grade;
import core.spring_basic_p1.member.Member;
import core.spring_basic_p1.member.MemberService;
import core.spring_basic_p1.member.MemberServiceImpl;
import core.spring_basic_p1.order.Order;
import core.spring_basic_p1.order.OrderService;
import core.spring_basic_p1.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}