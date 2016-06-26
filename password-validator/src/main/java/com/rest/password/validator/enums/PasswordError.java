package com.rest.password.validator.enums;


/**
 * The Enum PasswordError.
 */
public enum PasswordError {

    /** The constraint empty. */
    CONSTRAINT_EMPTY("password.empty.constraint"), /** The constraint size. */
    CONSTRAINT_SIZE("password.size.constraint"), /** The constraint lower case. */
    CONSTRAINT_LOWER_CASE("password.lowercase.constraint"), /** The constraint upper case. */
    CONSTRAINT_UPPER_CASE("password.uppercase.constraint"), /** The constraint number. */
    CONSTRAINT_NUMBER("password.number.constraint"), /** The constraint sequence. */
    CONSTRAINT_SEQUENCE("password.sequence.constraint");

    /** The error type. */
    private final String errorType;

    /**
     * Instantiates a new password error.
     * @param errorType the error type
     */
    private PasswordError(final String errorType) {
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return errorType;
    }

}
