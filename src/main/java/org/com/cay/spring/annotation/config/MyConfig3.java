package org.com.cay.spring.annotation.config;

import org.com.cay.spring.annotation.bean.Person;
import org.com.cay.spring.annotation.color.Green;
import org.com.cay.spring.annotation.color.Red;
import org.com.cay.spring.annotation.condition.LinuxCondition;
import org.com.cay.spring.annotation.condition.WindowsCondition;
import org.com.cay.spring.annotation.selector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class MyConfig3 {

	@Conditional(WindowsCondition.class)
	@Bean("bill")
	public Person person1(){
		return new Person("bill gates", 60);
	}
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person2(){
		return new Person("linus", 50);
	}
}
