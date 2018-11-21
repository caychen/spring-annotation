package org.com.cay.spring.annotation.animal;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {

	public Dog(){
		System.out.println("dog constructor...");
	}
	
	//对象创建并赋值之后调用
	@PostConstruct
	public void init(){
		System.out.println("dog init...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("dog destroy...");
	}
}
