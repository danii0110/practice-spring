package core.spring_basic_p1.order;


import core.spring_basic_p1.discount.DiscountPolicy;
import core.spring_basic_p1.discount.FixDiscountPolicy;
import core.spring_basic_p1.member.Member;
import core.spring_basic_p1.member.MemberRepository;
import core.spring_basic_p1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new
            MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    } }