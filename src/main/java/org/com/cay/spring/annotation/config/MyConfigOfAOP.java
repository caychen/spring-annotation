package org.com.cay.spring.annotation.config;

import org.com.cay.spring.annotation.aop.LogAspects;
import org.com.cay.spring.annotation.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:
 * 	程序运行期间动态的将某段代码切入到指定方法指定的位置，进行运行时的编译
 * 
 * 1、导入aop模块： spring-aspects
 * 2、定义业务逻辑类（MathCalculator），在业务逻辑运行的时候将日志进行打印
 * 3、定义一个日志切面类（LogAspects），切面类里面的方法需要动态感知MathCalculator运行状态
 * 		通知方法：
 * 			前置通知(@Before)： logStart，在目标方法div运行之前执行
 * 			后置通知(@After)： logEnd，在目标方法div运行结束之后执行，不管正常结束还是异常结束，都会执行
 * 			返回通知(@AfterReturn)： logReturn，在目标方法div正常放回之后执行
 * 			异常通知(@AfterThrowing)： logException，在目标方法div出现异常以后执行
 * 			环绕通知(@Around)： 动态代理，手动推进目标方法
 * 	
 * 4、给切面类的目标方法标注何时何地运行（通知注解）
 * 5、将切面类和业务逻辑类（目标方法所在类）注入到容器中
 * 6、必须告诉Spring哪个类是切面类（给切面类上添加@Aspect）
 * 7、给配置类上添加@EnableAspectJAutoProxy注解【开启基于注解的aop模式】
 * 
 * @author Cay
 * @date 2018年9月24日 下午9:21:48
 */
@Configuration
@EnableAspectJAutoProxy
public class MyConfigOfAOP{

	@Bean
	public MathCalculator calculator(){
		return new MathCalculator();
	}
	
	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
}
