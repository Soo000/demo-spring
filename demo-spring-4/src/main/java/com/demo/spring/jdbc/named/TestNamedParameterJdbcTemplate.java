package com.demo.spring.jdbc.named;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.demo.spring.jdbc.OfUser;

public class TestNamedParameterJdbcTemplate {

	private ApplicationContext ctx;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	{
		ctx = new ClassPathXmlApplicationContext("com/demospring/bean/jdbc/beans-jdbc.xml");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	
//	@Test
	public void testUpdate() {
		String sql = "insert into ofuser (username, creationDate, modificationDate) values (:username, :creationDate, :modificationDate)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", "ztest01");
		paramMap.put("creationDate", "001453951507501");
		paramMap.put("modificationDate", "001453951507601");
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testUpdate2() {
		String sql = "insert into ofuser (username, creationDate, modificationDate) values (:username, :creationDate, :modificationDate)";
		OfUser user = new OfUser();
		user.setUsername("ztest02");
		user.setCreationDate("001453951507501");
		user.setModificationDate("001453951507601");
		
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);
	}
}
