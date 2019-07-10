package com.kkwrite.demo.spring.redis.lettuce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.kkwrite.demo.spring.redis.lettuce.config.SentinelConfig;

public class LettuceApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(SentinelConfig.class);
		//cxt.getEnvironment().setActiveProfiles("sentinel");
		
		//cxt.register(ReadAndWriteConfig.class);
		//cxt.register(SentinelConfig.class);
		
		String[] beans = cxt.getBeanDefinitionNames();
		for (String bean: beans) {
			System.out.println(bean);
		}
				
		StringRedisTemplate stringRedisTemplate = cxt.getBean(StringRedisTemplate.class);
		String name = stringRedisTemplate.opsForValue().get("name");
		
		System.out.println("name = " + name);
		
		stringRedisTemplate.opsForValue().set("age", "36");
		
		cxt.close();
	}

}
