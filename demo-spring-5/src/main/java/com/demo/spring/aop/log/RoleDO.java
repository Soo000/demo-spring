package com.demo.spring.aop.log;

/**
 * 角色实体
 *
 * @author Ke Wang
 * @date 2020/7/14
 */
public class RoleDO {

    private Long id;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleDO{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
