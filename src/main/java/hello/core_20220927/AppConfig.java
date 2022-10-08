package hello.core_20220927;

import hello.core_20220927.discount.DiscountPolicy;
import hello.core_20220927.discount.FixDiscountPolicy;
import hello.core_20220927.discount.RateDiscountPolicy;
import hello.core_20220927.member.MemberService;
import hello.core_20220927.member.MemberServiceImpl;
import hello.core_20220927.member.MemoryMemberRepository;
import hello.core_20220927.order.OrderService;
import hello.core_20220927.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(
                memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
