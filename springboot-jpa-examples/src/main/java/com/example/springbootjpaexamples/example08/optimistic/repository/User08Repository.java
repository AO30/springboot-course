package com.example.springbootjpaexamples.example08.optimistic.repository;

import com.example.springbootjpaexamples.example08.optimistic.entity.User08;
import com.example.springbootjpaexamples.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User08Repository extends BaseRepository<User08, Integer> {
}
