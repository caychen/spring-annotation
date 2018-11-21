package org.com.cay.spring.annotation.processor;

import org.com.cay.spring.annotation.color.Color;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory...,bean数量 : " + beanFactory.getBeanDefinitionCount());
	}

	//BeanDefinitionRegistry是bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例。
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry...,bean数量 : " + registry.getBeanDefinitionCount());
		
		//下面两句一样
		BeanDefinition beanDefinition1 = new RootBeanDefinition(Color.class);
		BeanDefinition beanDefinition2 = BeanDefinitionBuilder.rootBeanDefinition(Color.class).getBeanDefinition();
		
		//手动注册两个组件
		registry.registerBeanDefinition("color1", beanDefinition1);
		registry.registerBeanDefinition("color2", beanDefinition2);
		
	}

}
