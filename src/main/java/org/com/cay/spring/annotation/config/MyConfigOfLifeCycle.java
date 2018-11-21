package org.com.cay.spring.annotation.config;

import org.com.cay.spring.annotation.animal.Cat;
import org.com.cay.spring.annotation.animal.Dog;
import org.com.cay.spring.annotation.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * bean的生命周期： 
 * 	bean创建---初始化---销毁的过程
 * 
 * 容器管理bean的生命周期 
 * 我们可以自定义初始化和销毁方法：容器在bean进行到生命周期的时候来调用我们自定义的初始化和销毁方法
 * 
 * 构造： 
 * 		单实例：在容器启动的时候创建对象 
 * 		多实例：在每次获取的时候创建对象 
 * 初始化： 
 * 		对象创建完成后，调用初始化方法 
 * 销毁： 
 * 		单实例：容器关闭的时候
 * 		多实例：容器不会管理这个bean，所以容器不会调用销毁方法
 * 
 * 1）、指定初始化和销毁方法： 
 * 		通过@Bean指定init-method和destroy-method
 * 2）、通过让Bean实现InitializingBean接口实现初始化逻辑 
 * 		实现DisposableBean接口实现销毁逻辑
 * 3）、使用JSR250:
 * 		@PostConstruct：在Bean创建完成并且属性值完成后，执行初始化。
 * 		@PreDestroy：在容器销毁Bean之前，通知进行清理工作。
 * 4）、BeanPostProcessor：bean的后置处理器：
 * 		在bean初始化前后进行一些处理工作：
 * 			postProcessBeforeInitialization：在初始化之前
 * 			postProcessAfterInitialization：在初始化之后
 * 
 * 
 * @author Cay
 * @date 2018年8月25日 下午5:18:43
 */
@Configuration
@ComponentScan("org.com.cay.spring.annotation.processor")
//@Import({ Cat.class, Dog.class })
public class MyConfigOfLifeCycle {

	// @Scope("prototype")
	//@Bean(initMethod = "init", destroyMethod = "destroy")
	public Car car() {
		return new Car();
	}
}
