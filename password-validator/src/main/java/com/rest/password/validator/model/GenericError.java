package com.rest.password.validator.model;


/**
 * The Class GenericError.
 */
public class GenericError {

    /** The error code. */
    private int errorCode;

    /** The error message. */
    private String errorMessage;


    /**
     * Gets the error code.
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the error code.
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Gets the error message.
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message.
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}

