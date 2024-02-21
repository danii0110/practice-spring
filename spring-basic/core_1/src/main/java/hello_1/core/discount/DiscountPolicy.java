package hello_1.core.discount;

import hello_1.core.member.Member;

public interface DiscountPolicy {
    //@return 할인 대상 금액
    int discount(Member member, int price);
}
//할인 정책 인터페이스