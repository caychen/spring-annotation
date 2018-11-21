package org.com.cay.spring.annotation.config;

import org.com.cay.spring.annotation.bean.Book;
import org.com.cay.spring.annotation.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration//配置类 ----> 配置文件
//包扫描----> <context:component-scan package=""/>
@ComponentScan(value="org.com.cay.spring",
	//排除要扫描的组件
	//excludeFilters={@Filter(type=FilterType.ANNOTATION, classes={Controller.class})},
	//禁用默认的扫描策略
	useDefaultFilters=false,
	//只扫描符合条件的组件
	includeFilters={
//			@Filter(type=FilterType.ANNOTATION, classes=Service.class),
//			@Filter(type=FilterType.ASSIGNABLE_TYPE, classes=BookDao.class)
			@Filter(type=FilterType.CUSTOM, classes={MyTypeFilter.class})
	}
)
public class MyConfig2 {

	@Bean//往容器中注册一个Bean组件，其中类型为返回值，id默认为方法名，也可以使用@Bean注解的name属性，来自定义id
	public Person person(){//默认单实例
		System.out.println("创建person实例...");
		return new Person("zhangsan", 20);
	}
	
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE		---> prototype
	 * ConfigurableBeanFactory#SCOPE_SINGLETON		---> singleton
	 * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST	---> request
	 * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	---> session
	 * 
	 * prototype：多实例
	 * singleton：单实例
	 * 
	 * 懒加载：
	 * 		只针对单实例bean：默认在容器启动的时候就会创建对象
	 * 		懒加载：容器启动不创建对象，第一次使用Bean的时候创建对象，并加入到容器中，之后每次再获取该对象的时候，直接从ioc容器中获取，不再重新创建。
	 */
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public Book book(){
		System.out.println("创建book实例...");
		return new Book();
	}
	
	@Lazy
	@Bean
	public Book book2(){
		System.out.println("创建book2实例...");
		return new Book();
	}
}
