package org.com.cay.spring.annotation.config;

import org.com.cay.spring.annotation.color.Green;
import org.com.cay.spring.annotation.color.Red;
import org.com.cay.spring.annotation.color.factory.ColorFactory;
import org.com.cay.spring.annotation.registrar.MyImportBeanDefinitionRegistrar;
import org.com.cay.spring.annotation.selector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ Red.class, Green.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class }) // 快速导入一个或多个第三方组件，id默认为全类名
public class MyConfig4 {

	@Bean
	public ColorFactory colorFactory(){
		return new ColorFactory();
	}
}
