package com.rest.password.validator;


import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Import(PasswordValidatorApplication.class)
@Configuration
public class Test {

    @Bean
    @Primary
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }

    // =================================================
    // Class Variables
    // =================================================

    // =================================================
    // Instance Variables
    // =================================================

    // =================================================
    // Constructors
    // =================================================

    // =================================================
    // Class Methods
    // =================================================

    // =================================================
    // Instance Methods
    // =================================================

    // =================================================
    // Accessors
    // =================================================

}
