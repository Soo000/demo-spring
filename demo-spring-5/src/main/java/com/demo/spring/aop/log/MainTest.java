package com.demo.spring.aop.log;

import com.demo.spring.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试日志切面注解
 *
 * @author Ke Wang
 * @date 2020/7/14
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(SpringConfig.class);

        // 用户管理
        UserService userService = cxt.getBean(UserService.class);

        UserDO userDO = new UserDO();
        userDO.setUsername("Wang Ke");
        userDO.setAge(18);
        userService.save(userDO);

        //userService.update(userDO);

        //userService.delete(1L);

        // 角色管理
        /*RoleService roleService = cxt.getBean(RoleService.class);
        RoleDO roleDO = new RoleDO();
        roleDO.setRoleName("管理员");
        roleService.save(roleDO);*/
    }

}
