package org.com.cay.spring.annotation.test;

import org.com.cay.spring.annotation.config.ExtendConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestExtend {

	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ExtendConfig.class);
		
		applicationContext.publishEvent(new ApplicationEvent("发布新事件") {
		});
		
		applicationContext.close();
	}

}
