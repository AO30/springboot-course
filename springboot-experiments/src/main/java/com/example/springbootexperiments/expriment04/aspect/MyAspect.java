package com.example.springbootexperiments.expriment04.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspect {
    private long startTime;

    @Pointcut("execution(* buyCar*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        this.startTime = System.currentTimeMillis();
    }
    @After("pointcut()")
    public void after(){
       long endTime = System.currentTimeMillis();
       System.out.println("方法执行了"+ (endTime-this.startTime) + "ms");
    }

    @Around("@annotation(myInterceptor)")
    public Object checkMethod(ProceedingJoinPoint joinPoint, MyInterceptor myInterceptor) throws Throwable {
        Object obj = joinPoint.proceed();
        for (MyInterceptor.MyInterceptorType au : myInterceptor.value()) {
            log.debug("{}", au);
        }
        return obj;
    }

    @Around("@within(myInterceptor)")
    public Object checkType(ProceedingJoinPoint joinPoint, MyInterceptor myInterceptor) throws Throwable {
        Object obj = joinPoint.proceed();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();

        if( ms.getMethod().getAnnotation(MyInterceptor.class) != null){
            return obj;
        }

        for (MyInterceptor.MyInterceptorType au : myInterceptor.value()) {
            log.debug("{}", au);
        }

        return obj;
    }
}
