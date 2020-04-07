package com.example.springbootspringmvcexamples1.example06.interceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example06/")
public class ExampleController06 {

    @GetMapping("admin/welcome")
    public Map getWelcome() {
        return Map.of("msg", "message");
    }
}
