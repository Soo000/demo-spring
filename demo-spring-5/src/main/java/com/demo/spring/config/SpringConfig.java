package com.demo.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring配置类
 *
 * @author Ke Wang
 * @date 2020/7/14
 */
@Configuration
@ComponentScan(basePackages = {"com.demo.spring.aop.log"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
