package com.example.springbootexperiments.expriment04.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyInterceptor {
    MyInterceptorType[] value() default MyInterceptorType.USER;

    public enum MyInterceptorType {
        USER, ADMIN, SUPERADMIN
    }
}

