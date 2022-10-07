package hello.core_20220927.discount;

import hello.core_20220927.member.Grade;
import hello.core_20220927.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    
    private int discountFixAmount = 1000;
    
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;    
        }
        
        return 0;
    }
}
