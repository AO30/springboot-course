package com.example.springbootexperiments.expriment03.repository;

import com.example.springbootexperiments.expriment03.entity.User03;
import com.example.springbootexperiments.expriment03.entity.UserAddress03;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddress03Repository extends BaseRepository<UserAddress03, Integer> {
    @Query("select a.user from Address02 a where a.detail=:detail and a.user.name=:uname")
    List<User03> list(@Param("detail") String detail, @Param("uname") String uname);
}
