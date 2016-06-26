package com.rest.password.validator.response;

import com.rest.password.validator.model.GenericError;

import java.util.Date;
import java.util.List;


/**
 * The Class GenericResponse.
 */
public class GenericResponse {

    /** The status. */
    private int status;

    /** The message. */
    private String message;

    /** The timestamp. */
    private Date timestamp;

    /** The errors. */
    private List<GenericError> errors;

    public GenericResponse() {
        super();
        this.timestamp = new Date();
    }
    /**
     * Instantiates a new generic response.
     * @param message the message
     */
    public GenericResponse(String message) {
        this();
        this.message = message;
    }


    public GenericResponse(String message, List<GenericError> errors, int status) {
        this();
        this.message = message;
        this.errors = errors;
        this.status = status;
    }



    /**
     * Gets the errors.
     * @return the errors
     */
    public List<GenericError> getErrors() {
        return errors;
    }

    /**
     * Sets the errors.
     * @param errors the errors to set
     */
    public void setErrors(List<GenericError> errors) {
        this.errors = errors;
    }

    /**
     * Gets the timestamp.
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp.
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the message.
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Gets the status.
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
