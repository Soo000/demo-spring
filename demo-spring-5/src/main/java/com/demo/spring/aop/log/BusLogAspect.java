package com.demo.spring.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述信息
 *
 * @author Ke Wang
 * @date 2020/7/14
 */
@Component
@Aspect
public class BusLogAspect {

    @Pointcut("execution(* com.demo.spring.aop.log.*.*(..))")
    public void cutAllMethod() {
    }

    /**
     * 查询记录日志
     */
    @Before("cutAllMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        String params = getMethodParams(joinPoint);
        System.out.println("参数信息：" + params);
    }

    /**
     * CUD(增、修、删)记录日志
     */
    @AfterReturning("cutAllMethod()")
    public void aroundMethod(JoinPoint joinPoint) {
        String params = getMethodParams(joinPoint);
        System.out.println("参数信息：" + params);

    }

    /**
     * 获取方法参数信息
     *
     * @param joinPoint
     * @return
     */
    private String getMethodParams(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        BusLog busLog = method.getAnnotation(BusLog.class);
        if (busLog == null) {
            return null;
        }

        Map<Integer, Object> paramMaps = new HashMap<>();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            paramMaps.put(i, args[i].toString());
        }
        return paramMaps.toString();
    }

}
