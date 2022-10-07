package hello.core_20220927.discount;

import hello.core_20220927.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
    
    
}
