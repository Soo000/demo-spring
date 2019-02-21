package com.demospringmybatis.dao.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demospringmybatis.po.User;

public class TestUserDao {

	private ApplicationContext cxt;
	public UserDao userDao;
	
	@Before
	public void before() throws Exception {
		cxt = (ApplicationContext) new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		userDao = (UserDao) cxt.getBean("userDao");
	}
	
	@Test
	public void testFindUserById() {
		int id = 1;
		try {
			User user = userDao.findUserById(id);
			System.out.println("user = " + user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInserUser() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = sdf.parse("1983-08-09");
			
			User user = new User();
			user.setUsername("wangke3");
			user.setBirthday(birthday);
			user.setSex("1");
			user.setAddress("陕西西安");
			
			userDao.insertUser(user);
			
			System.out.println("Insert user successful !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteUser() {
		try {
			int id = 39;
			userDao.deleteUser(id);
			System.out.println("Delete user successful !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
