package org.com.cay.spring.annotation.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/**
	 * metadataReader: 读取到的当前正在扫描的类信息
	 * metadataReaderFactory: 可以获取到其他任何类信息的工厂类
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		
		//获取当前正在扫描的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		//获取当前类的资源(类路径)
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println(">>>>>" + className);
		//如果扫描的类名中包含了er，则匹配
		if(className.contains("er")){
			return true;
		}
		return false;
	}

}
