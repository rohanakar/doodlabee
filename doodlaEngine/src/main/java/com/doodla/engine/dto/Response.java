package com.doodla.engine.dto;

public class Response<T> {
	
	private String message;
	private String error;
	private T data;
	private int code;
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public Object getError() {
		return error;
	}

	public Object getData() {
		return data;
	}

	public int getCode() {
		return code;
	}
	
	
}

