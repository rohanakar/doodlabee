package com.doodla.engine.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.doodla.engine.utils.JwtTokenService;

@Component
public class RequestMapper {

	@Autowired
	private JwtTokenService jwtService;
	
	public String getUserId() throws Exception{
	    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
	    if (requestAttributes instanceof ServletRequestAttributes) {
	        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
	        try {
	        	String token = request.getHeader("Authorization").split(" ")[1];
	        	String userId = jwtService.getIdFromToken(token);
	        	return userId;
	        }catch(Exception e) {
	        	throw new Exception("INVALID_TOKEN");
	        }
	    }
	    return null;
	}
}
