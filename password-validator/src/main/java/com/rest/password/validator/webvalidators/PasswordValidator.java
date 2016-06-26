package com.rest.password.validator.webvalidators;

import static com.rest.password.validator.constants.GenericConstants.PASSWORD_INPUT_PARAM;

import com.rest.password.validator.enums.PasswordError;
import com.rest.password.validator.model.LoginInput;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * The Class PasswordValidator.
 */
public class PasswordValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return LoginInput.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, PASSWORD_INPUT_PARAM, PasswordError.CONSTRAINT_EMPTY.toString());
        String password = ((LoginInput) target).getPassword();
        if (password.length() < 8 || password.length() > 19) {
            e.rejectValue(PASSWORD_INPUT_PARAM, PasswordError.CONSTRAINT_SIZE.toString(), new Object[] { "8", "20" }, null);
        }
        if (!password.matches(".*?[A-Z].*")) {
            e.rejectValue(PASSWORD_INPUT_PARAM, PasswordError.CONSTRAINT_UPPER_CASE.toString());
        }
        if (!password.matches(".*?[a-z].*")) {
            e.rejectValue(PASSWORD_INPUT_PARAM, PasswordError.CONSTRAINT_LOWER_CASE.toString());
        }
        if (!password.matches(".*?[0-9].*")) {
            e.rejectValue(PASSWORD_INPUT_PARAM, PasswordError.CONSTRAINT_NUMBER.toString());
        }
        if (password.matches(".*?(.{2,})\\1.*")) {
            e.rejectValue(PASSWORD_INPUT_PARAM, PasswordError.CONSTRAINT_SEQUENCE.toString());
        }
    }
}