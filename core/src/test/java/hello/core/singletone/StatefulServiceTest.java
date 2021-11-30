package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService statefulService1 = ac.getBean(StatefulService.class);
		StatefulService statefulService2 = ac.getBean(StatefulService.class);
	
		//ThreadA: A사용자 10000원 주문
//		statefulService1.order("userA", 10000);
		int userAPrice = statefulService1.order("userA", 10000);
		//ThreadB: B사용자 20000원 주문
//		statefulService2.order("userB", 20000);
		int userBPrice = statefulService2.order("userB", 20000);

		//ThreadA: A사용자 주문 금액 조회
//		int price = statefulService1.getPrice();
		System.out.println("price = " + userAPrice);
		System.out.println("price = " + userBPrice);
		
		Assertions.assertThat(userAPrice).isEqualTo(10000);
	}
	
	static class TestConfig {
		
		@Bean
		public StatefulService statefulServce() {
			return new StatefulService();
		}
	}
}
