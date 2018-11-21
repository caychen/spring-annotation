package org.com.cay.spring.annotation.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	//返回值就是要导入到容器中的组件全类名
	//AnnotationMetadata：当前标注@Import注解的类的所有注解信息
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		//方法不要返回null
		return new String[]{"org.com.cay.spring.annotation.color.Blue", "org.com.cay.spring.annotation.color.Yellow"};
	}
}
