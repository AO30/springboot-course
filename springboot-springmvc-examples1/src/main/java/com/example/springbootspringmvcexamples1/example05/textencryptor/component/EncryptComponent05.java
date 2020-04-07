package com.example.springbootspringmvcexamples1.example05.textencryptor.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncryptComponent05 {
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${my.secretkey}")
    private String secrekey;
    @Value("${my.salt}")
    private String salt;
    @Autowired
    private TextEncryptor encryptor;

    @Bean
    public TextEncryptor getTextEncryptor() {
        return Encryptors.text(secrekey, salt);
    }
}
