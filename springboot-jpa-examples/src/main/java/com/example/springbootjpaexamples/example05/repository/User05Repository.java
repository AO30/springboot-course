package com.example.springbootjpaexamples.example05.repository;

import com.example.springbootjpaexamples.example05.entity.User05;
import com.example.springbootjpaexamples.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User05Repository extends BaseRepository<User05, Integer> {
}
