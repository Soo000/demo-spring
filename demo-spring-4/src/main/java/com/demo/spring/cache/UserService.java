package com.demo.spring.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 注解@Cacheable使用实例
 *
 * @author Ke Wang
 */
@EnableCaching
public class UserService {

    @Cacheable(cacheNames = "user", key = "id")
    public String getUsername(Long id) {
        System.out.println("执行方法 getUsername().");
        return "wangke_" + System.currentTimeMillis();
    }

}
