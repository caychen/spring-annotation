package org.com.cay.spring.annotation.processor;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanFactoryPostProcessor#postProcessBeanFactory...");
		
		int processorCount = beanFactory.getBeanPostProcessorCount();
		
		System.out.println("当前processor数量：" + processorCount);
		
		String[] names = beanFactory.getBeanDefinitionNames();
		System.out.println("bean定义" + Arrays.asList(names));
	}

}
