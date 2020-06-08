package com.example.springbootexperiments;

import com.example.springbootexperiments.expriment02.repository.impl.BaseRespositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories(repositoryBaseClass = BaseRespositoryImpl.class)
class SpringbootExperimentsApplicationTests {

    @Test
    void contextLoads() {
    }

}
