package org.com.cay.spring.annotation.tx;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(){
		String sql = "insert into tbl_user(username, age) values(?, ?)";
		
		String username = UUID.randomUUID().toString().substring(0, 5);
		int age = new Random(System.currentTimeMillis()).nextInt(30);
		jdbcTemplate.update(sql, username, age);
	}
}
