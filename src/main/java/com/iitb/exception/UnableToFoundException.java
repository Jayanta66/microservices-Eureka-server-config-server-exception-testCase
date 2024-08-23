package com.iitb.exception;
/* Created by Arjun Gautam */

public class UnableToFoundException extends RuntimeException{
    public UnableToFoundException(String string){
        super("Page Not Found "+ string);
    }
}
