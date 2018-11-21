package org.com.cay.spring.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否是Windows系统
public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		// 获取当前环境变量
		Environment environment = context.getEnvironment();
		// 获取系统环境
		String systemName = environment.getProperty("os.name");
		if (systemName.contains("Windows")) {
			return true;
		}
		return false;
	}

}
