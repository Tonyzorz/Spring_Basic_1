package hello.core_20220927.order;

import hello.core_20220927.discount.DiscountPolicy;
import hello.core_20220927.discount.FixDiscountPolicy;
import hello.core_20220927.member.Member;
import hello.core_20220927.member.MemberRepository;
import hello.core_20220927.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
