package org.com.cay.spring.annotation.test;

import org.com.cay.spring.annotation.config.MyConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestLifeCycle {

	@Test
	public void test1(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);
		System.out.println("容器创建完成...");
		
		//applicationContext.getBean("car");
		applicationContext.close();
	}
}
