package com.demo.spring.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class DemoCache {

    public static void main(String[] args) {
        ApplicationContext cxt = new AnnotationConfigApplicationContext(DemoCache.class);
        UserService userService = cxt.getBean(UserService.class);

        for (int i = 0; i < 3; i++) {
            String username = userService.getUsername(1001L);
            System.out.println("查询到用户 username = " + username);
        }
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

}
