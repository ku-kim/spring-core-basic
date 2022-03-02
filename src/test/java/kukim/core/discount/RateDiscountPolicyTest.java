package kukim.core.discount;

import kukim.core.member.Grade;
import kukim.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.VisibilityPredicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VPI는 10%할인 되어야한다.")
    void vip_discount() {
        Member member = new Member(1L, "kukim", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아닌 경우 할인 적용되지 않아야 한다.")
    void vip_X_discount() {
        Member member = new Member(1L, "kukim", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}
