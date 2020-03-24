package com.example.springbootspringexamples.example03.jointpoint;

import org.springframework.stereotype.Component;

@Component
public class AOPService03 {
    public String hello(String name) {
        return "welcome" + name;
    }
}
