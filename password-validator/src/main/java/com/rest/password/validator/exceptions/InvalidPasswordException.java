package com.rest.password.validator.exceptions;

import com.rest.password.validator.constants.ErrorConstants;

import java.util.List;

/**
 * The Class InvalidPasswordException.
 */
public class InvalidPasswordException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7339031952826090428L;

    /** The code that is unique for each type of error. */
    int exceptionCode = ErrorConstants.INVALID_PASSWORD;

    /** The error list. */
    private List<String> errorList;

    /**
     * Instantiates a new invalid password exception.
     * @param errorList the error list
     */
    public InvalidPasswordException(List<String> errorList) {
        super("Invalid password.");
        this.errorList = errorList;
    }

    /**
     * Gets the exception code.
     * @return the exceptionCode
     */
    public int getExceptionCode() {
        return exceptionCode;
    }

    /**
     * Sets the exception code.
     * @param exceptionCode the exceptionCode to set
     */
    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    /**
     * Gets the error list.
     * @return the errorList
     */
    public List<String> getErrorList() {
        return errorList;
    }

    /**
     * Sets the error list.
     * @param errorList the errorList to set
     */
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
