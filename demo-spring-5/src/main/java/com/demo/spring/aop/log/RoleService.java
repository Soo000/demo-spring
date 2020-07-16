package com.demo.spring.aop.log;

import org.springframework.stereotype.Service;

/**
 * 角色管理，日志AOP
 *
 * @author Ke Wang
 * @date 2020/7/14
 */
@Service("roleService")
public class RoleService {

    @BusLog
    public RoleDO save(RoleDO roleDO) {
        System.out.println("保存角色 RoleDO: " + roleDO);
        return roleDO;
    }

    public Integer update(RoleDO roleDO) {
        System.out.println("更新角色 RoleDO: " + roleDO);
        return 1;
    }

    public Integer delete(Long id) {
        System.out.println("删除角色 RoleDO: " + id);
        return 1;
    }

}
