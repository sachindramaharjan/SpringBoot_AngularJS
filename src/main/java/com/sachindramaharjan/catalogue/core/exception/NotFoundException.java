package com.sachindramaharjan.catalogue.core.exception;

/**
 * Created by sachindra.maharjan on 4/25/16.
 */
public class NotFoundException extends RuntimeException  {

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public NotFoundException(Throwable cause){
        super(cause);
    }

}
