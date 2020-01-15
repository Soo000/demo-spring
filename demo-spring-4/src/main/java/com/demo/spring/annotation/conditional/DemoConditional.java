package com.demo.spring.annotation.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
public class DemoConditional {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(DemoConditional.class);
		ConfigurableEnvironment environment = cxt.getEnvironment();
		String osName = environment.getProperty("os.name");
		System.out.println(osName);
		
		String[] names = cxt.getBeanDefinitionNames();
		for (String name: names) {
			System.out.println(name);
		}
		
		cxt.close();
	}
	
	/**
	 * 如果是 Windows系统才注入该类
	 */
	@Bean("bill")
	@Conditional({WindowsCondition.class})
	public Person person01() {
		return new Person("Bill Gates", 62);
	}
	
	/**
	 * 如果是 Linux系统才注入该类
	 */
	@Bean("linus")
	@Conditional({LinuxCondition.class})
	public Person person02() {
		return new Person("Linus", 48);
	}
	
}
