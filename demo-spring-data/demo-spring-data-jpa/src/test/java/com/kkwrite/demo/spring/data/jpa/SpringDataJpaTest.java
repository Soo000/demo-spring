package com.kkwrite.demo.spring.data.jpa;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataJpaTest {

	ApplicationContext cxt  = null;
	
	@Before
	public void before() {
		cxt = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	@Test
	public void testDataSource() throws Exception {
		DataSource dataSource = cxt.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
}
