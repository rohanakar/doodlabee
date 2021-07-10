package com.doodla.engine.exceptions;

public class InvalidTokenException extends RuntimeException {
	
	 public InvalidTokenException(String errorMessage, Throwable err) {
	        super(errorMessage, err);
	    }
}
