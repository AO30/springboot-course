package com.example.springbootspringmvcexamples1.example05.textencryptor.component;

import lombok.Data;

@Data
public class MyToken {
    public enum Role{
        USER, ADMIN
    }
    private Integer uid;
    private Role role;
}
