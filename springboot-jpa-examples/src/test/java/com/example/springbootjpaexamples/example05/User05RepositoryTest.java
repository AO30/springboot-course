package com.example.springbootjpaexamples.example05;

import com.example.springbootjpaexamples.example05.entity.User05;
import com.example.springbootjpaexamples.example05.repository.User05Repository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class User05RepositoryTest {
    @Autowired
    private User05Repository user05Repository;
    @Autowired
    EntityManager manager;
    @Test
    public void test_addUser(){
        User05 user05 = new User05();
        user05.setName("AO");
        user05Repository.save(user05);
        user05.setName("SUN");
    }
    @Test
    public void test_addUser2() {
        User05 user05 = user05Repository.findById(3).orElse(null);
        log.debug("{}", user05.getInsertTime());
    }
    @Test
    public void test_addUser3() {
        User05 user05 = new User05();
        user05.setId(2);
        user05Repository.save(user05);
    }
    @Test
    public void test_addUser4() {
        User05 user05 = new User05();
        user05.setName("AO");
        user05Repository.save(user05);
        log.debug("{}", user05.getId());
        log.debug("{}", user05.getInsertTime());
    }

    @Test
    public void test_refresh(){
        User05 user05 = new User05();
        user05.setName("SUN");
        manager.persist(user05);
        user05.setName("AO");
        manager.refresh(user05);
        log.debug("{}",user05.getName());
        log.debug("{}",user05.getId());
        log.debug("{}",user05.getInsertTime());
    }
    @Test
    public void test_refresh2(){
        User05 user05 = new User05();
        user05.setName("SUN");
        user05Repository.save(user05);
        user05Repository.refresh(user05);
        log.debug("{}",user05.getName());
        log.debug("{}",user05.getId());
        log.debug("{}",user05.getInsertTime());
    }
}
