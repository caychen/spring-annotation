package org.com.cay.spring.annotation.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspects {

	// 抽取公共的切入点表达式
	@Pointcut("execution(* org.com.cay.spring.annotation.aop.*.*(..))")
	public void logging() {
	}

	@Before(value = "logging()")
	public void logStart(JoinPoint joinPoint) {
		System.out
				.println(joinPoint.getSignature().getName() + "运行，参数列表是: {" + Arrays.asList(joinPoint.getArgs()) + "}");
	}

	@After(value = "logging()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "结束...");
	}

	@AfterReturning(value = "logging()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName() + "正常结束，结果是: {" + result + "}");
	}

	@AfterThrowing(value = "logging()", throwing = "e")
	public void logException(JoinPoint joinPoint, Exception e) {
		System.out.println(joinPoint.getSignature().getName() + "异常，异常信息: {" + e.getMessage() + "}");
	}
}
