package com.demospringmybatis.main;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	private static final String configLocation = "spring/applicationContext.xml"; 
	private ApplicationContext cxt;
	private SqlSessionFactory sqlSessionFacotry;
	
	@Before
	public void setUp() {
		cxt = new ClassPathXmlApplicationContext(configLocation);
	}
	
	@Test
	public void testGetSqlSessionFactory() {
		sqlSessionFacotry = (SqlSessionFactory) cxt.getBean("sqlSessionFactory");
	}
}
