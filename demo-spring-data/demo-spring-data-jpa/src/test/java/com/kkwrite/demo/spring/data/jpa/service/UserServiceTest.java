package com.kkwrite.demo.spring.data.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.kkwrite.demo.spring.data.jpa.dao.UserRepository;
import com.kkwrite.demo.spring.data.jpa.entity.User;

public class UserServiceTest {

	ApplicationContext cxt;
	
	UserService userService;
	
	UserRepository userRepository;
	
	@Before
	public void before() {
		cxt = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		userService = (UserService) cxt.getBean(UserService.class);
		userRepository = (UserRepository) cxt.getBean(UserRepository.class);
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void batchSave() throws Exception {
		List<User> users = new ArrayList<User>();
		for (int i = 'a'; i < 'z'; i++) {
			User user = new User(((char) i) + "", "123456");
			user.setIsDeleted(0);
			user.setGmtCreate(new Date());
			user.setGmtModified(new Date());
			users.add(user);
		}
		userService.save(users);
	}
	
	/**
	 * 排序分页查询
	 */
	@Test
	public void findAll() {
		// 排序参数
		Order idOrder = new Order(Direction.DESC, "id");
		Order usernameOrder = new Order(Direction.ASC, "username");
		Sort sort = new Sort(idOrder, usernameOrder);
		// 分页参数
		PageRequest pageRequest = new PageRequest(0, 5, sort);
		// 执行查询
		Page<User> userPage = userRepository.findAll(pageRequest);
		
		//userPage.forEach(u -> System.out.println(u));
		
		userPage.forEach(System.out :: println);
		
		long totalRecords = userPage.getTotalElements();
		long totalPages = userPage.getTotalPages();
		long page = userPage.getNumber();
		long pageRecords = userPage.getNumberOfElements();
		List<User> users = userPage.getContent();
		
		System.out.println("总记录数：" + totalRecords);
		System.out.println("总记页数：" + totalPages);
		System.out.println("当前页码：" + page);
		System.out.println("当前页记录数：" + pageRecords);
		System.out.println("查询结果：" + users);
	}
	
	@Test
	public void jpaSpecificationExecutor() {
		int page = 0;
		int size = 5;
		// 分页参数
		PageRequest pageRequest = new PageRequest(page, size);
		// 查询条件
		/*Specification<User> specification = new Specification<User>() {

			*//**
			 * @param root 查询的实体类
			 * @param query 可以从中得到 root 对象，即告知 JPA Criteria 查询要查询哪一个实体类。
			 * 				还可以来添加查询条件，还可以结合 EntityManager 对象得到最终查询的 TypeQuery 对象
			 * @param cb 用于创建 Criteria 相关对象的工厂。当然可以从中获取到 Predicate 对象
			 * @return Predicate 代表一个查询条件
			 *//*
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path path = root.get("id");
				Predicate predicate = cb.gt(path, 5);
				return predicate;
			}
		};*/
		
		Specification<User> specification = (root, query, cb) -> {
			Path path = root.get("id");
			Predicate predicate = cb.gt(path, 5);
			return predicate; 
		};
		
		Page<User> userPage = userRepository.findAll(specification, pageRequest);
		System.out.print(userPage);
	}
	
	@Test
	public void findAllPagingByUsername() {
		Page<User> page = userService.findAllPagingByUsername("a", 1, 10);
		page.forEach(System.out :: println);
	}
	
}
