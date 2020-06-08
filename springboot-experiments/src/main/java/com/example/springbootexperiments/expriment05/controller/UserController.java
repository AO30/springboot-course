package com.example.springbootexperiments.expriment05.controller;

import com.example.springbootexperiments.expriment05.entity.User05;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/experiment05/")
public class UserController {
    @GetMapping("index")
    public Map getIndex() {
        return  Map.of("name","BO");
    }

    private final List<User05> USERS = create();
    private List<User05> create() {
        User05 u1 = new User05(1,"BO","123123");
        User05 u2 = new User05(2,"ZHANG","123123");
        User05 u3 = new User05(3,"WU","123123");
        return List.of(u1, u2, u3);
    }
    @GetMapping("users")
    public Map getUsers(@RequestBody User05 user) {
        log.debug(user.getUserName());
        return Map.of();
    }

    @PostMapping("users")
    public Map postUsers02() {
        User05 u4 = new User05(4,"SUN","123123");
        User05 u5 = new User05(4,"AO","123123");
        return Map.of("users", List.of(u4, u5));
    }

    @GetMapping("users/{uid}")
    public Map getUsers03(@PathVariable int uid) {
        User05 user = USERS.stream()
                .filter(u -> u.getId() == uid)
                .findFirst()
                .orElse(new User05());
        return Map.of("user", user);
    }
}
