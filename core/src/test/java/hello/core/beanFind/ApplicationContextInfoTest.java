package hello.core.beanFind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class ApplicationContextInfoTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("��� �� ����ϱ�")
	void findAllBean() {
		String[] beanDefintionNames = ac.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefintionNames) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("name = " + beanDefinitionName + " object = " + bean);
		}
	}
	
	@Test
	@DisplayName("���ø����̼� �� ����ϱ�")
	void findApplicationBean() {
		String[] beanDefintionNames = ac.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefintionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			//ROLE_APPLICATION: ���� ����� ���ø����̼� ��
			//ROLE_INFRASTRUCTURE: �������� ���ο��� ����ϴ� ��
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("name = " + beanDefinitionName + " object = " + bean);	
			}
		}
	}
}
