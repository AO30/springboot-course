package com.example.springbootexperiments.expriment03;

import com.example.springbootexperiments.expriment03.entity.Address03;
import com.example.springbootexperiments.expriment03.entity.User03;
import com.example.springbootexperiments.expriment03.repository.Address03Repository;
import com.example.springbootexperiments.expriment03.repository.UserAddress03Repository;
import com.example.springbootexperiments.expriment03.repository.User03Repository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;

@SpringBootTest
@Slf4j
@Entity
public class JPQLTest {
    @Autowired
    private User03Repository userRepository;
    @Autowired
    private Address03Repository addressRepository;
    @Autowired
    private UserAddress03Repository userAddressRepository;

    @Transactional
    @Rollback(value = false)
    @Test
    public void init(){
        User03 u = new User03();
        u.setName("BO");
        userRepository.save(u);
        User03 u2 =new User03();
        u2.setName("SUN");
        userRepository.save(u2);

        Address03 a = new Address03();
        a.setDetail("956");
        addressRepository.save(a);

        Address03 a2 = new Address03();
        a.setDetail("925");
        addressRepository.save(a2);

        Address03 a3 = new Address03();
        a.setDetail("1201");
        addressRepository.save(a3);
    }

    @Test
    public void test_findUser(){
        userRepository.findById(1).orElse(null);
    }

    @Test
    public void test_findAddress(){
        addressRepository.list("925")
                .forEach(a -> log.debug("{}",a.getId()));
    }

    @Test
    public void test_listAddresses(){
        userAddressRepository.list("956","BO")
                .forEach(a -> log.debug("{}",a.getId()));
    }
}
