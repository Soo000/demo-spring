package com.demospring.bean.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TestJdbc {

	private ApplicationContext ctx;
	private JdbcTemplate jdbcTemplate;
	
	{
		ctx = new ClassPathXmlApplicationContext("com/demospring/bean/jdbc/beans-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
//	@Test
	public void testConnect() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());	
	}
	
	/**
	 * 注意不是 jdbcTemplate.queryForObject(sql, requiredType)
	 */
//	@Test
	public void testQueryForObject() {
		String sql = "select * from ofuser where username = ?";
		
		RowMapper<OfUser> rowMapper = new BeanPropertyRowMapper<OfUser>(OfUser.class);
		OfUser user = jdbcTemplate.queryForObject(sql, rowMapper, "wangke");
		System.out.println(user);
	}
	
	/**
	 * 查询某一列的值（统计数据）
	 */
	@Test
	public void testQueryForColumn() {
		String sql = "select count(username) from ofuser";
		
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
//	@Test
	public void testQuery() {
		String sql = "select * from ofuser";
		
		RowMapper<OfUser> rowMapper = new BeanPropertyRowMapper<OfUser>(OfUser.class);
		List<OfUser> users = jdbcTemplate.query(sql, rowMapper);
		System.out.println(users);
	}
	
//	@Test
	public void testUpdate() {
		String sql = "update ofuser set name = ? where username = ?";
		jdbcTemplate.update(sql, "王珂", "wangke");
	}
	
//	@Test
	public void testBatchUpdate() {
		String sql = "insert into ofuser (username, creationDate, modificationDate) values (?, ?, ?)";
		
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		
		batchArgs.add(new Object[] {"ztest01", "001453951507502", "001453951507601"});
		batchArgs.add(new Object[] {"ztest02", "001453951507502", "001453951507602"});
		batchArgs.add(new Object[] {"ztest03", "001453951507502", "001453951507603"});
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}

}
