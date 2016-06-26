package com.rest.password.validator.model;


/**
 * The Class LoginInput.
 */
public class LoginInput {

    /** The password. */
    private String password;

    /**
     * Instantiates a new login input.
     */
    public LoginInput() {}

    /**
     * Instantiates a new login input.
     * @param password the password
     */
    public LoginInput(final String password) {
        super();
        this.password = password;
    }

    /**
     * Gets the password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "LoginInput [password=" + password + "]";
    }

    /**
     * Sets the password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
