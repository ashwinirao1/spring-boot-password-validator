package com.rest.password.validator.controller;

import com.rest.password.validator.webvalidators.PasswordValidator;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * The Class BaseController.
 */
public abstract class BaseController {

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

    /**
     * Inits the binder.
     * @param binder the binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new PasswordValidator());
    }

}
