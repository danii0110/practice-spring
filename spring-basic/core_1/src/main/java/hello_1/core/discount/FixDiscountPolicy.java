package hello_1.core.discount;

import hello_1.core.member.Grade;
import hello_1.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { //enum 타입은 == 써야됨
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
//정액 할인 정책 구현체