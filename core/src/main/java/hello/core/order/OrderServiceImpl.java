package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository;	//final 키워드를 사용하면 생성자에서 발생할 수 있는 오류를 방지할 수 있음
	private final DiscountPolicy discountPolicy;		//생성자 멤버 초기화 누락 시 컴파일 에러 발생!
	
	@Autowired
	//Spring Bean이고 생성자가 딱 한개만 존재하면 autowired를 생략해도 의존성 주입이 자동으로 진행됨.
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
