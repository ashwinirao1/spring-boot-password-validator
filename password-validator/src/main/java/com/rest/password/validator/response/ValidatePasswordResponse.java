package com.rest.password.validator.response;

import com.rest.password.validator.constants.GenericConstants;

/**
 * The Class ValidatePasswordResponse.
 */
public class ValidatePasswordResponse extends GenericResponse {

    /** The password. */
    private String password;

    /**
     * Instantiates a new validate password response.
     * @param password the password
     */
    public ValidatePasswordResponse(final String password) {
        super(GenericConstants.SUCCESS);
        this.password = password;
    }

    /**
     * Gets the password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
