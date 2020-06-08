package com.example.springbootexperiments.expriment02;

import com.example.springbootexperiments.expriment02.entity.Address02;
import com.example.springbootexperiments.expriment02.entity.User02;
import com.example.springbootexperiments.expriment02.repository.User02Repository;
import com.example.springbootexperiments.expriment02.service.UserService02;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.awt.*;

@SpringBootTest
@Slf4j
public class UserService02Test {
    @Autowired
    private User02Repository userRepository;
    @Autowired
    EntityManager manager;

    @Test
    public void addUserAddress(){
        User02 user = userRepository.findById(1).orElse(null);
        Address02 address = new Address02();
        address.setDetail("925");
        address.setUser(user);
        manager.persist(address);

        List<Address02> addresses = user.getAddresses();
        addresses.add(address);
        user.setAddresses(addresses);
    }

    @Test
    public void updateUser(User02 u){
        User02 u1 = new User02();
        u1 = userRepository.findById(1);
        u1.setName("PANLIU");
        userRepository.save(u1);
        userRepository.refresh(u1);
    }

    @Test
    public void getUserAddress(User02 u){
        User02 user = userRepository.findById(1).orElse(null);
        assert user != null;
        user.getAddresses().forEach(a -> {
            System.out.println(a.getDetail());
        });
    }

    @Test
    public void deleteUser(){
        User02 user = userRepository.findById(1).orElse(null);

        List<Address02> addresses = user.getAddresses();
        Address02 address = addresses.get(1);
        address.setUser(null);
        addresses.remove(address);
        user.setAddresses(addresses);

    }
}
