package com.demospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.demospring.po.Person;

/** 
 * Spring 配置类
 *
 * @author Soosky Wang
 * @date 2018年8月29日 下午3:06:26 
 * @version 1.0.0
 */
@Configuration
public class MySpringConfig {

	/**
	 *  ConfigurableBeanFactory#SCOPE_PROTOTYPE
		ConfigurableBeanFactory#SCOPE_SINGLETON
		org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
		org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * @return
	 */
	@Bean
	@Scope("prototype")
	public Person person() {
		return new Person("wangke", 35);
	}
	
	@Bean
	public Person person2() {
		return new Person("soosky", 36);
	}
	
}
