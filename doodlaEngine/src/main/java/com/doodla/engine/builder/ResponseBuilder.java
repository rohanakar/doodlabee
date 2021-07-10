package com.doodla.engine.builder;

import com.doodla.engine.dto.Response;

public class ResponseBuilder<T> {
	
	private String message;
	private String error;
	private T data;
	private int code;
	
	public ResponseBuilder<T> data(T data) {
		this.data = data;
		return this;
	}
	
	public ResponseBuilder<T> message(String message) {
		this.message = message;
		return this;
	}
	
	public ResponseBuilder<T> error(String error) {
		this.error = error;
		return this;
	}
	
	public ResponseBuilder<T> status(int code) {
		this.code = code;
		return this;
	}
	
	public Response<T> build() {
		Response<T> r = new Response<T>();
		r.setCode(code);
		r.setData(data);
		r.setError(error);
		r.setMessage(message);
		return r;
	}
}

