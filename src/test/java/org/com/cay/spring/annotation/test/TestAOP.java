package org.com.cay.spring.annotation.test;

import org.com.cay.spring.annotation.aop.MathCalculator;
import org.com.cay.spring.annotation.config.MyConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {

	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MyConfigOfAOP.class);
		
		MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
		
		int result1 = calculator.div(20, 5);
		System.out.println("result1: " + result1);
		
		System.out.println("==================");
		int result2 = calculator.div(10, 0);
		System.out.println("result2: " + result2);
	}

}
