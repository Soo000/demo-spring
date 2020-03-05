package com.alisls.demo.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * SpringMvc配置（相当于springmvc.xml）
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.alisls.demo.spring.security",
                includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)}
              )
public class WebConfig implements WebMvcConfigurer {

    /**
     * 视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("login");

        // 当访问根路径(/)重定向到/login
        registry.addViewController("/").setViewName("redirect:/login");
    }

}
