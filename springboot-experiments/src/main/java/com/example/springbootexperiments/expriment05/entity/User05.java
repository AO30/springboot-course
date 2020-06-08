package com.example.springbootexperiments.expriment05.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "password" })
public class User05 {
    private int id;
    private String userName;
    private String password;

    public User05 (Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
