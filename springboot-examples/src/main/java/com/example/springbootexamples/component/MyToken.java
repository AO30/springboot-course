package com.example.springbootexamples.component;

import com.example.springbootexamples.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "Authorization";
    public static final String UID = "uid";
    public static final String ROLE = "role";
    private Integer uid;
    private User.Role role;
}
