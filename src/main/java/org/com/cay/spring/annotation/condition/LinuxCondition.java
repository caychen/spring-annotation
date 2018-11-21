package org.com.cay.spring.annotation.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否是Linux系统
public class LinuxCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		//获取到ioc使用的BeanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		
		//获取当前环境变量
		Environment environment = context.getEnvironment();
		
		//获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		
		//获取系统环境
		String systemName = environment.getProperty("os.name");
		if(systemName.contains("Linux")){
			return true;
		}
		return false;
	}

}
