package com.doodla.engine.exceptions;

public class FollowRequestPending extends RuntimeException {
	
	public FollowRequestPending(String errorMessage, Throwable err) {
	        super(errorMessage, err);
	    }
}
