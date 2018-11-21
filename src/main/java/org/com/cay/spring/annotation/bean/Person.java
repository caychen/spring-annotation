package org.com.cay.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	/**
	 * 使用@Value赋值
	 * 	1、基本数值类型和String
	 * 	2、SpEL表达式: #{}
	 * 	3、${}: 取出配置文件中的值
	 * 
	 */
	
	@Value("${person.nickName}")
	private String name;
	
	@Value("${person.age}")
	private Integer age;
	
}
