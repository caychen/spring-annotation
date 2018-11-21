package org.com.cay.spring.annotation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @Profile:指定组件在某种环境下才能激活并注册到容器中，不指定的话，任何环境都能注册该组件
 * 		Spring提供的，可以根据当前环境，动态的激活和切换一系列组件的功能。
 * 		default: 默认的profile
 * 			
 * 1）、加了环境标识的Bean，只有在指定的环境被激活的情况下才能注册到容器中，默认环境是default
 * 2）、写在配置类上，只有在指定环境的时候，整个配置类里面的所有配置才能生效
 * 3）、没有标注环境标识的Bean，在任何环境下都是加载的。
 * 
 * @author Cay
 * @date 2018年9月11日 下午9:25:37
 */
@Configuration
public class MyConfigOfProfile implements EmbeddedValueResolverAware{

	@Value("${db.user}")
	private String user;
	
	private String driverClass;
	
	@Bean
	@Profile(value="test")
	public DataSource dataSourceTest(@Value("${db.password}")String password) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql:///test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Bean
	@Profile(value="dev")
	public DataSource dataSourceDev(@Value("${db.password}")String password) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql:///mybatis");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Bean
	@Profile(value="prod")
	public DataSource dataSourceProd(@Value("${db.password}")String password) throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql:///ssm");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		this.driverClass = resolver.resolveStringValue("${db.driverClass}");
	}
	
}
