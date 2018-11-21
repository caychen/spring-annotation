package org.com.cay.spring.annotation.config;

import java.util.EventListener;

import org.com.cay.spring.annotation.color.Blue;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展配置：
 *  1、BeanFactoryPostProcessor：BeanFactory后置处理器
 * 		BeanPostProcessor：Bean后置处理器，bean创建对象初始化前后进行拦截工作。
 *  	BeanFactoryPostProcessor在BeanFactory在标准初始化之后调用，所有bean定义已经保存加载到BeanFactory，但是bean实例还未创建
 * 
 *  2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor：BeanFactory
 *  	在所有bean定义信息将要被加载，bean实例还未创建时调用。
 *  	BeanDefinitionRegistryPostProcessor优先于BeanFactoryPostProcessor执行
 *  	所以可以通过BeanDefinitionRegistryPostProcessor给容器中再额外添加组件。
 * 
 * 	3、ApplicationListener：监听容器中发布的事件，事件驱动模型开发
 * 		public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 * 
 * 	步骤：
 * 		（1）、写一个监听器来监听某个事件（ApplicationEvent及其子类）；
 * 		（2）、把监听器加入到容器中；
 * 		（3）、只要容器中有相关事件的发布，就会触发该监听器
 * 		（4）、手动发布事件
 * 			（i）、applicationContext.publishEvent
 * 
 * @author Cay
 * @date 2018年10月23日 下午9:30:42
 */
@Configuration
@ComponentScan(basePackages={"org.com.cay.spring.annotation"})
public class ExtendConfig {

	@Bean
	public Blue blue(){
		return new Blue();
	}
}
