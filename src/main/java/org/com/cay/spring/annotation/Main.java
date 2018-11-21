package org.com.cay.spring.annotation;

import java.util.Arrays;

import org.com.cay.spring.annotation.bean.Person;
import org.com.cay.spring.annotation.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		Person person1 = (Person)applicationContext.getBean("person");
		System.out.println(person1);
		System.out.println("=================");
		
		Person person2 = applicationContext.getBean(Person.class);
		System.out.println(person2);
		System.out.println("=================");
		
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.asList(beanDefinitionNames).stream().forEach(System.out::println);
		System.out.println("=================");
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		Arrays.asList(beanNamesForType).stream().forEach(System.out::println);
		System.out.println("=================");
	}
}
