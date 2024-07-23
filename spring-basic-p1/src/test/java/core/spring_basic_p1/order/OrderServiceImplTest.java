package core.spring_basic_p1.order;

import core.spring_basic_p1.discount.DiscountPolicy;
import core.spring_basic_p1.discount.FixDiscountPolicy;
import core.spring_basic_p1.member.Grade;
import core.spring_basic_p1.member.Member;
import core.spring_basic_p1.member.MemberRepository;
import core.spring_basic_p1.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}