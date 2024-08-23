package com.iitb.exception;
/* Created by Arjun Gautam */

public class UnableToSaveException extends RuntimeException{
    public UnableToSaveException(String string){
        super("Page Not Found "+ string);
    }
}
