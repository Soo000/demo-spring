package com.demo.spring.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务日志切面
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
     * 前置通知，查询记录日志
     */
    @Before("cutAllMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        String params = getMethodParams(joinPoint);
        System.out.println("执行前置通知，获取方法入参：" + params);
    }

    /**
     * 环绕通知
     */
    @Around("cutAllMethod()")
    public Object roundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        // 连接点方法的实参
        Object[] args = proceedingJoinPoint.getArgs();
        // 连接点方法的方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 连接点方法所在的对象
        Object targetObj = proceedingJoinPoint.getTarget();
        String targetClassName = targetObj.getClass().getName();

        Object result = null;
        try {
            System.out.println("执行环绕通知的前置通知...");
            // 执行连接点的方法 获取返回值
            result = proceedingJoinPoint.proceed(args);
            System.out.println("执行环绕通知的返回通知 result = " + result);
        } catch (Throwable e) {
            System.out.println("执行环绕通知的异常通知 e: " + e.getMessage());
        } finally {
            System.out.println("环绕通知通知的最终通知");
        }
        return result;
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After("cutAllMethod()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("执行后置通知");
    }

    /**
     * 返回通知，CUD(增、修、删)记录日志
     */
    @AfterReturning(pointcut = "cutAllMethod()", returning = "result")
    public void afterReturingMethod(JoinPoint joinPoint, Object result) {
        // 返回结果
        System.out.println("执行返回通知：" + result);
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "cutAllMethod()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("执行异常通知：" + e.getMessage());
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
