package com.rest.password.validator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


/**
 * The Class ServletInitializer.
 */
public class ServletInitializer extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PasswordValidatorApplication.class);
    }

}





