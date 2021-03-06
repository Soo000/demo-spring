package com.kkwrite.demo.spring.redis.lettuce.sentinel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class SentinelTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() throws InterruptedException {
        // 每个一秒钟，操作一下redis，看看最终效果
        int i = 0;
        while (true) {
            i++;
            stringRedisTemplate.opsForValue().set("test-value", String.valueOf(i));
            System.out.println("修改test-value值为: " + i);
            Thread.sleep(1000L);
        }
    }

}
