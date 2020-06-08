package com.example.springbootexperiments.expriment06.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = { "password" })
public class User06 {
    private String userName;
    private String password;

    public User06 (String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
