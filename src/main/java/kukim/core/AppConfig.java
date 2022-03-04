package kukim.core;

import kukim.core.discount.DiscountPolicy;
import kukim.core.discount.FixDiscountPolicy;
import kukim.core.discount.RateDiscountPolicy;
import kukim.core.member.MemberRepository;
import kukim.core.member.MemberService;
import kukim.core.member.MemberServiceImpl;
import kukim.core.member.MemoryMemberRepository;
import kukim.core.order.OrderService;
import kukim.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
