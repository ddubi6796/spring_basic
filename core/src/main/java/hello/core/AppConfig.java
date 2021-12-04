package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
// Configuration을 사용하면 바이트코드를 조작하는 CGLIB을 사용하여 싱글톤을 보장함.
public class AppConfig {
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();	//다른 Repo사용 시 이 부분만 변경하면 됨.
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();		//다른 할인 정책 사용 시 이 부분만 변경하면 됨.
		return new RateDiscountPolicy();
	}

	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		//생성자 주입 - 생성자를 통해 객체 인스턴스 주입
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
}
