package com.rest.password.validator.controller;

import static com.rest.password.validator.constants.ControllerPathConstants.VALIDATE_URL;

import com.rest.password.validator.exceptions.InvalidPasswordException;
import com.rest.password.validator.model.LoginInput;
import com.rest.password.validator.response.ValidatePasswordResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class ValidationController.
 */
@RestController
@RequestMapping(VALIDATE_URL)
public class ValidationController extends BaseController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationController.class);

    /** The message source. */
    private final MessageSource messageSource;

    /**
     * Instantiates a new validation controller.
     * @param messageSource the message source
     */
    @Autowired
    public ValidationController(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    /**
     * Validate password.
     * @param loginInputData the login input data
     * @param bindingResult the binding result
     * @param locale the locale
     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ValidatePasswordResponse> validatePassword(@Validated final LoginInput loginInputData, BindingResult bindingResult, Locale locale) {
        LOGGER.debug("Input value from the request passed : ", loginInputData);
        if (bindingResult.hasFieldErrors()) {
            List<String> errorList = new ArrayList<>();
            bindingResult.getFieldErrors().stream().forEach(error -> {
                errorList.add(messageSource.getMessage(error.getCode(), error.getArguments(), locale));
            });
            throw new InvalidPasswordException(errorList);
        }
        return new ResponseEntity<ValidatePasswordResponse>(new ValidatePasswordResponse(loginInputData.getPassword()), HttpStatus.OK);
    }
}
