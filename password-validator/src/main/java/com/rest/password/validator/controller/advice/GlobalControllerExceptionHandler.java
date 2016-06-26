package com.rest.password.validator.controller.advice;

import com.rest.password.validator.constants.GenericConstants;
import com.rest.password.validator.exceptions.InvalidPasswordException;
import com.rest.password.validator.model.GenericError;
import com.rest.password.validator.response.GenericResponse;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class GlobalControllerExceptionHandler.
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);


    /**
     * Handle invalid password.
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler({ InvalidPasswordException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GenericResponse> handleInvalidPassword(final InvalidPasswordException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return new ResponseEntity<GenericResponse>(getExceptionResponse(exception.getErrorList(), exception.getExceptionCode(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Gets the exception response.
     * @param messageList the message list
     * @param code the code
     * @return the exception response
     */
    private GenericResponse getExceptionResponse(List<String> messageList, int code, int httpErrorCode) {
        List<GenericError> errors = new ArrayList<>();
        messageList.forEach(msg -> {
            GenericError newError = new GenericError();
            newError.setErrorCode(code);
            newError.setErrorMessage(msg);
            errors.add(newError);
        });
        return new GenericResponse(GenericConstants.FAILURE, errors, httpErrorCode);
    }

}