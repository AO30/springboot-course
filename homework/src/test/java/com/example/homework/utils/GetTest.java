package com.example.homework.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class GetTest {

    @Test
    public void test_get(){
        String name = "AO";
        int length = 5;
        if (name.length() <= length) {
            log.debug( "输入：{},长度小于5",name);
        }
    }
}
