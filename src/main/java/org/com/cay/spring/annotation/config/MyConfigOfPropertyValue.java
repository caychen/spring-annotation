package org.com.cay.spring.annotation.config;

import org.com.cay.spring.annotation.bean.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 
 * @author Cay
 * @date 2018年8月25日 下午5:18:43
 */
//@PropertySource读取外部配置文件中的k/v，并保存到运行环境中
@PropertySources({
	@PropertySource(value="classpath:/person.properties")
})
@Configuration
public class MyConfigOfPropertyValue {

	@Bean
	public Person person() {
		return new Person();
	}
}
