package org.com.cay.spring.annotation.test;

import java.util.Arrays;
import java.util.Map;

import org.com.cay.spring.annotation.bean.Person;
import org.com.cay.spring.annotation.config.MyConfig;
import org.com.cay.spring.annotation.config.MyConfig2;
import org.com.cay.spring.annotation.config.MyConfig3;
import org.com.cay.spring.annotation.config.MyConfig4;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {

	@Test
	public void test1(){
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
	
	@SuppressWarnings("resource")
	@Test
	public void test2(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
		System.out.println("ioc容器创建完成...");
		Object obj1 = applicationContext.getBean("person");
		Object obj2 = applicationContext.getBean("person");
		System.out.println(obj1 == obj2);
		
		Object obj3 = applicationContext.getBean("book");
		Object obj4 = applicationContext.getBean("book");
		System.out.println(obj3 == obj4);
		
		Object obj5 = applicationContext.getBean("book2");
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test3(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig3.class);
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		Arrays.asList(beanNamesForType).stream().forEach(System.out::println);
		
		Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
		System.out.println(beansOfType);
	}
	
	@Test
	public void testImport(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig4.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.asList(beanDefinitionNames).stream().forEach(System.out::println);
	}
	
	@Test
	public void testFactoryBean(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig4.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.asList(beanDefinitionNames).stream().forEach(System.out::println);
		
		//获取到的是实现FactoryBean接口后通过getObject返回的实际bean
		Object bean = applicationContext.getBean("colorFactory");
		System.out.println("bean的类型： " + bean.getClass());
		
		//获取factorybean的自身bean
		//org.springframework.beans.factory.BeanFactory.FACTORY_BEAN_PREFIX = "&";
		Object bean2 = applicationContext.getBean("&colorFactory");
		System.out.println("bean2的类型： " + bean2.getClass());
	}
}
