package com.example.springbootspringmvcexamples1.example04.passwordencoder.service;

import com.example.springbootspringmvcexamples1.example04.passwordencoder.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserService04 {
    private Map<String, User> map = createUser();
    private Map<String, User> createUser() {
        User u = new User();
        u.setUserName("AO");
        u.setPassword("$2a$10$KIygBLlz4ZtRM6WdCJxuNeKD870GTEMgAMkcYnmxO3E7pTfxmnV2q");
        return Map.of("AO", u);
    }

    public User getUser(String userName) {
        return map.get(userName);
    }
}
