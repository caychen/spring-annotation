package org.com.cay.spring.annotation.test;

import org.com.cay.spring.annotation.config.TxConfig;
import org.com.cay.spring.annotation.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTx {

	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				TxConfig.class);
		
		UserService userService = applicationContext.getBean(UserService.class);
		
		userService.insertUser();
		
		applicationContext.close();
	}

}
