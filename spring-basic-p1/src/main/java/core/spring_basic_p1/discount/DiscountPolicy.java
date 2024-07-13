package core.spring_basic_p1.discount;

import core.spring_basic_p1.member.Member;

public interface DiscountPolicy {
    //return 할인 대상 금액
    int discount(Member member, int price);
}
