package org.com.cay.spring.annotation.config;

import org.com.cay.spring.annotation.bean.Person;
import org.com.cay.spring.annotation.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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
public class MyConfig {

	@Bean//往容器中注册一个Bean组件，其中类型为返回值，id默认为方法名，也可以使用@Bean注解的name属性，来自定义id
	public Person person(){
		return new Person("zhangsan", 20);
	}
}
