package com.example.springbootexperiments.expriment01.service;

import com.example.springbootexperiments.expriment01.entity.Address;
import com.example.springbootexperiments.expriment01.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Slf4j
@Service
public class UserAddressService {
    @Autowired
    EntityManager manager;

    public void addUserAddress() {
        User u = new User();
        u.setName("AO");
        manager.persist(u);

        Address a = new Address();
        a.setDetail("956");
        a.setUser(u);
        manager.persist(a);

        Address a2 = new Address();
        a2.setDetail("925");
        a2.setUser(u);
        manager.persist(a2);

    }
}
