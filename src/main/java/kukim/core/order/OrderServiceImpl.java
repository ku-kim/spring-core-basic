package kukim.core.order;

import kukim.core.discount.DiscountPolicy;
import kukim.core.discount.FixDiscountPolicy;
import kukim.core.discount.RateDiscountPolicy;
import kukim.core.member.Member;
import kukim.core.member.MemberRepository;
import kukim.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
