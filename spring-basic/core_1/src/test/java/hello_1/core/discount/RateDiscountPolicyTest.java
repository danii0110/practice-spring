package hello_1.core.discount;

import hello_1.core.member.Grade;
import hello_1.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() { //함수 뜻은 vip는 잘 적용되어야 한다는 뜻
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        //Assertions.assertThat(discount).isEqualTo(1000); //Assertions가 간결해지는 단축키 : option + enter
        assertThat(discount).isEqualTo(1000); //간결해진 이후, 위에 import 생김
    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() { //함수 뜻은 vip는 잘 적용되어야 한다는 뜻
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}
//RateDiscountPolicy가 정말 10% 할인이 되는지 보기 위함
//+) 테스트를 할 때에는 성공 테스트도 중요하지만, 실패 테스트도 꼭 만들어 봐야 한다.