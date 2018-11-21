package org.com.cay.spring.annotation.test;

import java.util.Arrays;

import org.com.cay.spring.annotation.bean.Person;
import org.com.cay.spring.annotation.config.MyConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

public class TestPropertyValue {
	
	@Test
	public void test1(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigOfPropertyValue.class);
		printBeans(applicationContext);
		
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		
		Environment environment = applicationContext.getEnvironment();
		String value = environment.getProperty("person.nickName");
		System.out.println("from environment: " + value);
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		
		Arrays.asList(beanDefinitionNames).stream().forEach(System.out::println);
	}
}
