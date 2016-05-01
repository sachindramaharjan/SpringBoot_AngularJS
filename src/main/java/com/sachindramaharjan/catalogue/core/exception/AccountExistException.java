package com.sachindramaharjan.catalogue.core.exception;

import com.sachindramaharjan.catalogue.core.entity.Account;

/**
 * Created by sachindra.maharjan on 5/1/16.
 */
public class AccountExistException extends RuntimeException {

    public AccountExistException(String message){
        super(message);
    }

    public AccountExistException(String message, Throwable cause){
        super(message, cause);
    }

    public AccountExistException(Throwable cause){
        super(cause);
    }

}
