package com.example.springbootexperiments.expriment03.repository;

import com.example.springbootexperiments.expriment03.entity.User03;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User03Repository extends BaseRepository<User03, Integer> {
    @Query("from User02 u where u.id=:id")
    List<User03> list(@Param("id") int id);
}
