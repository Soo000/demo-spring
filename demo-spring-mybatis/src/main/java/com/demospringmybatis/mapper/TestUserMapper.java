package com.demospringmybatis.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demospringmybatis.po.User;
import com.demospringmybatis.po.UserCustom;
import com.demospringmybatis.po.UserQueryVo;

public class TestUserMapper {

	private ApplicationContext cxt;
	
	@Before
	public void setUp() throws Exception {
		cxt = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	
	@Test
	public void testFindUserById() throws Exception {
		// MyBatis自动生成 Mapper的代理对象
		UserMapper userMapper = (UserMapper) cxt.getBean("userMapper");

		int id = 1;
		User user = userMapper.findUserById(id);
		System.out.println("TestUserMapper.testFindUserById() user = " + user);
	}
	
	@Test
	public void testFindUserByName() throws Exception {
		// MyBatis自动生成 Mapper的代理对象
		UserMapper userMapper = (UserMapper) cxt.getBean("userMapper");

		List<User> users = userMapper.findUserByName("张");
		System.out.println("TestUserMapper.testFindUserByName() users = " + users);
	}
	
	@Test
	public void testFindUserList() throws Exception {
		// MyBatis自动生成 Mapper的代理对象
		UserMapper userMapper = (UserMapper) cxt.getBean("userMapper");

		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> userCustoms = userMapper.findUserList(userQueryVo);
		System.out.println("TestUserMapper.testFindUserList() users = " + userCustoms);
	}
	
	@Test
	public void findUserByIdResultMap() throws Exception {
		// MyBatis自动生成 Mapper的代理对象
		UserMapper userMapper = (UserMapper) cxt.getBean("userMapper");

		User user = userMapper.findUserByIdResultMap(1);
		System.out.println("TestUserMapper.findUserByIdResultMap() user = " + user);
	}
	
	@Test
	public void testFindUserCount() throws Exception {
		// MyBatis自动生成 Mapper的代理对象
		UserMapper userMapper = (UserMapper) cxt.getBean("userMapper");

		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张");
		userQueryVo.setUserCustom(userCustom);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println("TestUserMapper.testFindUserCount() count = " + count);
	}
	
	@Test
	public void testInserUser() throws Exception {
		// MyBatis自动生成 Mapper的代理对象
		UserMapper userMapper = (UserMapper) cxt.getBean("userMapper");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = sdf.parse("1983-08-09");
		
		User user = new User();
		user.setUsername("wangke");
		user.setBirthday(birthday);
		user.setSex("1");
		user.setAddress("陕西西安");
		
		userMapper.insertUser(user);
	}
	
	@Test
	public void deleteUser() throws Exception {
		// MyBatis自动生成 Mapper的代理对象
		UserMapper userMapper = (UserMapper) cxt.getBean("userMapper");
		
		userMapper.deleteUserById(41);
	}
}
