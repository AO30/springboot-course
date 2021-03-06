package com.example.springbootexperiments.expriment06.interceptor;

import com.example.springbootexperiments.expriment06.component.EncryptorComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private EncryptorComponent encrypt;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Optional.ofNullable(request.getHeader("AUTHORIZATION"))
                .map(auth -> encrypt.decryptToken(auth))
                .ifPresentOrElse(userName -> {
                    request.setAttribute("userName", userName);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "未登录");
                });

        return true;
    }
}

