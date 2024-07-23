package core.spring_basic_p1.order;


import core.spring_basic_p1.annotation.MainDiscountPolicy;
import core.spring_basic_p1.discount.DiscountPolicy;
import core.spring_basic_p1.member.Member;
import core.spring_basic_p1.member.MemberRepository;
import core.spring_basic_p1.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 변수의 생성자를 만들어줌
public class OrderServiceImpl implements OrderService {
    //@Autowired 생략 가능
    private final MemberRepository memberRepository;
    //@Autowired 생략 가능
    private final DiscountPolicy discountPolicy; //구체화에 의존하지 않고 추상화에 의존하도록 코드를 수정

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}