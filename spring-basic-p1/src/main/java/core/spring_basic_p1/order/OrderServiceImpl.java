package core.spring_basic_p1.order;


import core.spring_basic_p1.discount.DiscountPolicy;
import core.spring_basic_p1.member.Member;
import core.spring_basic_p1.member.MemberRepository;
import core.spring_basic_p1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //구체화에 의존하지 않고 추상화에 의존하도록 코드를 수정

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    } }