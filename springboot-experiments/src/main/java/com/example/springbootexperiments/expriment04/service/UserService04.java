package com.example.springbootexperiments.expriment04.service;

import com.example.springbootexperiments.expriment04.aspect.MyInterceptor;
import org.springframework.stereotype.Service;

@Service
public class UserService04 {
    public void buyCar() {
    }

    public void getUser() {
    }

    @MyInterceptor(value = MyInterceptor.MyInterceptorType.ADMIN)
    public void addUser() {

    }
}
