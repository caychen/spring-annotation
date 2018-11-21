package org.com.cay.spring.annotation.registrar;

import org.com.cay.spring.annotation.animal.Tiger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata：当前类的注解信息
	 * 
	 * BeanDefinitionRegistry：BeanDefinition注册类
	 * 		把所有需要添加到容器中的bean，手动通过{@link BeanDefinitionRegistry#registerBeanDefinition(String, BeanDefinition)}进行注册
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub

		//因为Yellow这个Bean是通过@Import导入的，所以bean的id为全类名，所以这里需要判断全类名才行
		boolean hasBean = registry.containsBeanDefinition("org.com.cay.spring.annotation.color.Yellow");
		System.out.println(">>>>>>hasBean: " + hasBean);
		if(hasBean){
			BeanDefinition beanDefinition = new RootBeanDefinition(Tiger.class);
			registry.registerBeanDefinition("tiger", beanDefinition);
		}
	}

}
