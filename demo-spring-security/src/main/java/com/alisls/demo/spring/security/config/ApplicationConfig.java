package com.alisls.demo.spring.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring容器配置（相当于applicationContext.xml）
 */
@Configuration
@ComponentScan(basePackages = "com.alisls.demo.spring.security",
                excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)}
              )
public class ApplicationConfig {
}
