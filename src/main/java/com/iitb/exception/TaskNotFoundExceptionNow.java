package com.iitb.exception;
/* Created by Arjun Gautam */

public class TaskNotFoundExceptionNow extends RuntimeException{
    public TaskNotFoundExceptionNow(String string){
        super("Could not found the Task with id "+ string);
    }
}
