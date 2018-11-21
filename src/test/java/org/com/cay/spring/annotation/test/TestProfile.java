package org.com.cay.spring.annotation.test;

import java.util.Arrays;

import javax.sql.DataSource;

import org.com.cay.spring.annotation.config.MyConfigOfProfile;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestProfile {

	// 1、使用命令行动态参数：在虚拟机参数位置加载-Dspring.profiles.active=...
	@Test
	public void test1() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MyConfigOfProfile.class);

		printDataSourceBean(applicationContext);
	}

	private void printDataSourceBean(AnnotationConfigApplicationContext applicationContext) {
		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		Arrays.asList(beanNamesForType).stream().forEach(System.out::println);
	}

	// 2、代码方式激活环境
	@Test
	public void test2() {
		// 创建applicationContext
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test", "dev");
		// 设置主配置类
		applicationContext.register(MyConfigOfProfile.class);
		// 启动刷新
		applicationContext.refresh();
		
		printDataSourceBean(applicationContext);
	}

}
