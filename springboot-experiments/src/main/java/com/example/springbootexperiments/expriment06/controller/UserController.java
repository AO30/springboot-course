package com.example.springbootexperiments.expriment06.controller;

import com.example.springbootexperiments.expriment06.component.EncryptorComponent;
import com.example.springbootexperiments.expriment06.entity.User06;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;


@Slf4j
@RestController
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    EncryptorComponent encryptorComponent;
    private Map<String, User06> map = null;

    @PostMapping("register")
    public Map postRegister(@RequestBody User06 user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        map = Map.of(user.getUserName(),user);
        return map;
    }

    public User06 getUser(String userName) {
        return map.get(userName);
    }


    @PostMapping("login")
    @ResponseBody
    public Map postLogin(@RequestBody User06 user, HttpServletResponse response){
        // 先查询用户是否存在
        User06 u = getUser(user.getUserName());

        if (user == null ||!passwordEncoder.matches(user.getPassword(),user.getPassword())){
            log.debug("登录失败");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名密码错误");
        }else {
            //登录成功，添加token等操作
            log.debug("登录成功");
            response.setHeader("AUTHORIZATION",encryptorComponent.TextEncryptor(user.getUserName()));
        }
        return  Map.of("user", user);
    }

    @GetMapping("index")
    public Map getIndex(HttpServletRequest request){
        String name = (String) request.getAttribute("userName");
        return Map.of("userName",name);
    }

}
