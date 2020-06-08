package com.example.springbootexperiments.expriment02.service;

import com.example.springbootexperiments.expriment02.entity.Address02;
import com.example.springbootexperiments.expriment02.entity.User02;
import com.example.springbootexperiments.expriment02.repository.Address02Repository;
import com.example.springbootexperiments.expriment02.repository.User02Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class UserService02 {
    @Autowired
    private User02Repository userRepository;
    @Autowired
    private Address02Repository addressRepository;

    //user CRUD
    public void addUser(User02 user) {
      userRepository.save(user);
    }

    public void updateUser (User02 user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    public User02 getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    //address CRUD
    public void addAddress(Address02 address) {
        addressRepository.save(address);
    }

    public void updateAddress (Address02 address) {
        addressRepository.save(address);
    }

    public Address02 getAddress(int id){
        return addressRepository.findById(id).orElse(null);
    }

    public void deleteAddress (int id) {
        addressRepository.deleteById(id);
    }
}
