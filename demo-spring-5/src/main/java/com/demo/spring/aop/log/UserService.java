package com.demo.spring.aop.log;

import org.springframework.stereotype.Service;

/**
 * 用户管理，日志AOP
 *
 * @author Ke Wang
 * @date 2020/7/14
 */
@Service("userService")
public class UserService {

    @BusLog
    public UserDO save(UserDO userDO) {
        System.out.println("保存用户 UserDO: " + userDO);
        if (userDO.getId() == null) {
            throw new RuntimeException("测试异常通知");
        }
        return userDO;
    }

    public Integer update(UserDO userDO) {
        System.out.println("更新用户数 1");
        return 1;
    }

    public Integer delete(Long id) {
        System.out.println("更新用户数 1");
        return 1;
    }

}
