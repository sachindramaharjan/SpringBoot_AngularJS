package com.sachindramaharjan.catalogue.core.exception;

/**
 * Created by sachindra.maharjan on 4/17/16.
 */
public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }
}
