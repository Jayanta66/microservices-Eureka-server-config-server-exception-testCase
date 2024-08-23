package com.iitb.exception;
/* Created by Arjun Gautam */

public class PageNotFoundException extends RuntimeException{
    public PageNotFoundException(String string){
        super("Page Not Found "+ string);
    }
}
