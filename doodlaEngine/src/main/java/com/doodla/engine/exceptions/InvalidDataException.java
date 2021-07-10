package com.doodla.engine.exceptions;

public class InvalidDataException extends RuntimeException {
	
	public InvalidDataException(String errorMessage, Throwable err) {
	        super(errorMessage, err);
	    }
}
