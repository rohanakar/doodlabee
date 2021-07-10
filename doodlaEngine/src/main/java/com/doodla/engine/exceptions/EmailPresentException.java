package com.doodla.engine.exceptions;

public class EmailPresentException extends RuntimeException {
	
	public EmailPresentException(String errorMessage, Throwable err) {
	        super(errorMessage, err);
	    }
}
