package com.example.springbootjpaexamples.example09.pessimistic.service;

import com.example.springbootjpaexamples.example09.pessimistic.entity.User09;
import com.example.springbootjpaexamples.example09.pessimistic.repository.User09Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class User09Service{
    @Autowired
    private User09Repository user09Repository;
    public void addUser(User09 u){
        user09Repository.save(u);
    }

    public void buy(int uid, int expense) {
        User09 u = user09Repository.find(1);
        int newBalance = u.getBalance() - expense;
        if(newBalance >= 0) {
            u.setBalance(newBalance);
            log.debug("花费后的余额:{}",newBalance);
        }else {
            log.debug("余额不足");
        }
    }
}
