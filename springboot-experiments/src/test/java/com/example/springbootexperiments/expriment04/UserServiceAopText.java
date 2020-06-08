package com.example.springbootexperiments.expriment04;

import com.example.springbootexperiments.expriment04.service.UserService04;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceAopText {
    @Autowired
    private UserService04 userService;

    @Test
    public void test_buy() {
        userService.buyCar();
    }

    @Test
    public void test_getUser(){
        userService.getUser();
    }

    @Test
    public void test_addUser(){
        userService.addUser();
    }
}
