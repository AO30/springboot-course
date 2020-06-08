package com.example.springbootexperiments.expriment01;

import com.example.springbootexperiments.expriment01.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@SpringBootTest
@Slf4j
public class addUserAddressTest {
    @Autowired
    private UserAddressService uservice;

    @Test
    public void test_addUserAddress(){
        uservice.addUserAddress();
    }
}
