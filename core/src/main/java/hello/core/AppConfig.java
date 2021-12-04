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
// Configuration�� ����ϸ� ����Ʈ�ڵ带 �����ϴ� CGLIB�� ����Ͽ� �̱����� ������.
public class AppConfig {
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();	//�ٸ� Repo��� �� �� �κи� �����ϸ� ��.
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();		//�ٸ� ���� ��å ��� �� �� �κи� �����ϸ� ��.
		return new RateDiscountPolicy();
	}

	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		//������ ���� - �����ڸ� ���� ��ü �ν��Ͻ� ����
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
}
