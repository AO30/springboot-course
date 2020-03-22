package com.example.springbootjpaexamples;

import com.example.springbootjpaexamples.repository.impl.BaseRespostoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRespostoryImpl.class)
public class SpringbootJpaExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaExamplesApplication.class, args);
    }

}
