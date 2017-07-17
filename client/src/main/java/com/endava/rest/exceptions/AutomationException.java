package com.endava.rest.exceptions;

import org.testng.Reporter;

public class AutomationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutomationException(String message, Throwable cause) {
		super(message, cause);
	    Reporter.log(message + "Caused by: "+cause.getStackTrace().toString());	
	}

	public AutomationException(String message) {
		super(message);
		Reporter.log("Following error has occured: "+message);
	}

	public AutomationException(Throwable cause) {
		super(cause);
	}

}


