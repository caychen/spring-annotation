package org.com.cay.spring.annotation.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 声明式事务 
 * 环境搭建： 
 * 	1、导入依赖 spring-jdbc、数据源、数据库驱动 
 * 	2、配置数据源、JdbcTemplate
 * 	3、给业务逻辑方法上标注 @Transactional，表示当前方法是一个事务方法
 * 	4、配置类上添加 @EnableTransactionManagement，开启基于注解的事务管理功能
 * 	5、配置事务管理器来控制事务
 * 
 * @author Cay
 * @date 2018年9月27日 下午10:29:33
 */
@Configuration
@ComponentScan(basePackages = { "org.com.cay.spring.annotation.tx" })
@EnableTransactionManagement
public class TxConfig {

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///test");
		dataSource.setUser("root");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	//注册事务管理器
	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
}
