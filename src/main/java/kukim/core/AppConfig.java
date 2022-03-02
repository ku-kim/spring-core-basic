package kukim.core;

import kukim.core.discount.FixDiscountPolicy;
import kukim.core.discount.RateDiscountPolicy;
import kukim.core.member.MemberRepository;
import kukim.core.member.MemberService;
import kukim.core.member.MemberServiceImpl;
import kukim.core.member.MemoryMemberRepository;
import kukim.core.order.OrderService;
import kukim.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }


    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
