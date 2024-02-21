package hello_1.core.order;

import hello_1.core.discount.DiscountPolicy;
import hello_1.core.member.Member;
import hello_1.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    //멤버 리파지토리에서 회원을 찾아야 되기 때문에 필요
    //1. 주문 생성 요청
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private DiscountPolicy discountPolicy; //구체화에 의존하지 않고, 추상화에 의존한다.

    private final MemberRepository memberRepository; //뒷부분 지운 후 생성자 추가
    private final DiscountPolicy discountPolicy; //final이 되어 있으면 무조건 할당은 해주어야 됨

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //2. 회원 정보 조회
        Member member = memberRepository.findById(memberId);
        //3. 할인 정책에 넘겨줌
        //할인에 대한 것은 discountPolicy 니가 알아서 해줘. 나는 몰라라는 식으로 설계했기 때문에 좋은 코드이다.(단일 체계 원칙 잘 지킴)
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
//주문 서비스 구현체