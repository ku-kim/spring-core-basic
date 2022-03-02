package kukim.core.discount;

import kukim.core.member.Grade;
import kukim.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountRateAmount = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRateAmount / 100;
        }
        return 0;
    }
}
