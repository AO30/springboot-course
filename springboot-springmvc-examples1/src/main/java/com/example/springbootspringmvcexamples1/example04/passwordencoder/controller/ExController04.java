package com.example.springbootspringmvcexamples1.example04.passwordencoder.controller;

import com.example.springbootspringmvcexamples1.example04.passwordencoder.entity.User;
import com.example.springbootspringmvcexamples1.example04.passwordencoder.service.UserService04;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example04/")
public class ExController04 {
    @Autowired
    private UserService04 userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("login")
    public Map login(@RequestBody User user){
        //先查询用户是否存在
        User u = userService.getUser(user.getUserName());
        if (u == null ||!passwordEncoder.matches(user.getPassword(),u.getPassword())){
            log.debug("登录失败");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名密码错误");
        }else {
            //登录成功，添加token等操作
            log.debug("登录成功");
        }
        return  Map.of("user", u);
    }
}
