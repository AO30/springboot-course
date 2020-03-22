package com.example.springbootjpaexamples.example07.jpql;

import com.example.springbootjpaexamples.example07.jpql.jpql.entity.Address07;
import com.example.springbootjpaexamples.example07.jpql.jpql.entity.User07;
import com.example.springbootjpaexamples.example07.jpql.jpql.repository.Address07Repository;
import com.example.springbootjpaexamples.example07.jpql.jpql.repository.User07Repository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private User07Repository user07Repository;
    @Autowired
    private Address07Repository address07Repository;

    @Transactional
    @Rollback(value = false)
    @Test
    public void init(){
        User07 u = new User07();
        u.setName("AO");
        user07Repository.save(u);
        User07 u2 =new User07();
        u2.setName("SUN");
        user07Repository.save(u2);

        Address07 a = new Address07();
        a.setDetail("956");
        a.setUser(u);
        address07Repository.save(a);

        Address07 a2 = new Address07();
        a.setDetail("925");
        a.setUser(u);
        address07Repository.save(a2);

        Address07 a3 = new Address07();
        a.setDetail("1201");
        a.setUser(u2);
        address07Repository.save(a3);
    }

    @Test
    public void test_listUsers(){
        user07Repository.list("AO")
                .forEach(u -> log.debug("{}",u.getName()));
    }

    @Test
    public void test_listUsers2(){
        address07Repository.list("956")
                .forEach(u -> log.debug("{}",u.getName()));
    }

    @Test
    public void test_listUsers3(){
        address07Repository.find(1)
                .getName();
    }

    @Test
    public void test_listAddresses(){
        address07Repository.list("956","AO")
                .forEach(a -> log.debug("{}",a.getId()));
    }

    @Test
    public void find_User(){
        user07Repository.findByName("AO")
                .forEach(u -> log.debug("{}",u.getId()));
    }

    @Test
    public void test_page() {
        address07Repository.list("956", PageRequest.of(0, 20))
                .getContent()
                .forEach(address07 -> log.debug("{}", address07.getUser().getName()));
    }

    @Transactional
    @Rollback(value = false)
    @Test
    public void test_update(){
        user07Repository.update(1, "ZHANG");
        }


}
