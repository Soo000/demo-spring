package com.demo.spring.aop.log;

import java.lang.annotation.*;

/**
 * 业务日志
 *
 * @author Ke Wang
 * @date 2020/7/14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BusLog {

}
