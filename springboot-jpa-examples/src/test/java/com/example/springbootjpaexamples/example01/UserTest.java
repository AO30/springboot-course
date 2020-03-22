package com.example.springbootjpaexamples.example01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class UserTest {
    @Autowired
    private EntityManager manager;

    @Test
    public void test_addUser(){
        User user = new User();
        user.setName("AO");
        user.setBirthday(LocalDate.of(1999,10,10));
        manager.persist(user);
        log.debug("{}", user.getId());
    }
}
