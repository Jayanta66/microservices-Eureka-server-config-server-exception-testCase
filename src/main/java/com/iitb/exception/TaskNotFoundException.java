package com.iitb.exception;

public class TaskNotFoundException extends Exception {

	String msg;

	public TaskNotFoundException(String noCustomers) {
		super("Could not found the Task with id ");
		this.msg = noCustomers;
	}
	
	
	

}
