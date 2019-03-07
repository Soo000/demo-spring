package com.kkwrite.demo.spring4.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demospring.bean.DataSource;
import com.demospring.bean.annotation.controller.UserController;
import com.demospring.bean.annotation.repository.UserRepository;
import com.demospring.bean.annotation.service.UserService;
import com.demospring.bean.autowire.PersonAutowire;
import com.demospring.bean.cycle.CycleBean;
import com.demospring.po.Car;
import com.demospring.po.Person;

public class Main {

	private static ApplicationContext ctx;
	
	static {
		ctx = new ClassPathXmlApplicationContext("spring.xml");
	}
	
	public static void main(String[] args) {
		Car car = (Car) ctx.getBean("car");
		System.out.println("car=" + car);
		
		Car car4 = (Car) ctx.getBean("car4");
		System.out.println("car4=" + car4);
		
		Car car5 = (Car) ctx.getBean("car5");
		System.out.println("car5=" + car5);
		
		Car car7 = (Car) ctx.getBean("car7");
		System.out.println("car7=" + car7);		
		
		Person person = (Person) ctx.getBean("person");
		System.out.println("person=" + person);
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println("dataSource=" + dataSource);
		
		PersonAutowire personAutowire = (PersonAutowire) ctx.getBean("personAutowire");
		System.out.println("personAutowire=" + personAutowire);
		
		PersonAutowire personAutowire2 = (PersonAutowire) ctx.getBean("personAutowire2");
		System.out.println("personAutowire2=" + personAutowire2);
		
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
		CycleBean cycleBean = (CycleBean) classPathXmlApplicationContext.getBean("cycleBean");
		System.out.println(cycleBean);
		classPathXmlApplicationContext.close();
		
		UserController userController = (UserController) ctx.getBean("userController");
		userController.save();
		
		UserService userService = (UserService) ctx.getBean("userService");
		userService.save();
		
		UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
		userRepository.save();
	}

}
