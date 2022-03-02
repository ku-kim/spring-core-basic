package kukim.core.order;

import kukim.core.AppConfig;
import kukim.core.member.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    void init() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        memberService = applicationContext.getBean("memberService", MemberService.class);
        orderService = applicationContext.getBean("orderService", OrderService.class);
    }

    @AfterEach
    void clear() {
    }


    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "kukim", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        int result = order.calculatePrice();

        assertThat(result).isEqualTo(9000);
    }
}