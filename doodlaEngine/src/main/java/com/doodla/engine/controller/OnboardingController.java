package com.doodla.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doodla.engine.builder.ResponseBuilder;
import com.doodla.engine.dto.Response;
import com.doodla.engine.dto.UserRequestDTO;
import com.doodla.engine.dto.UserResponseDTO;
import com.doodla.engine.service.OnboardingService;

@Controller
@RequestMapping("v1/onbaording")
public class OnboardingController {
	
	@Autowired
	private OnboardingService onboardingService;
	
	@PostMapping("/register")
	public ResponseEntity<Response<UserResponseDTO>>  register(@RequestBody UserRequestDTO request) {
		try {
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.data(onboardingService.registerUser(request))
												.status(201)
												.build(),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<Response<UserResponseDTO>>(new  ResponseBuilder<UserResponseDTO>()
												.status(500)
												.message(e.getMessage())
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/login/sso")
	public ResponseEntity<Response<UserResponseDTO>> loginSSO(@RequestBody UserRequestDTO request) {
		try {
			UserResponseDTO response = onboardingService.loginSSO(request);
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.data(response)
												.status(response.isFirstTime()?201:200)
												.build(),
												response.isFirstTime()?HttpStatus.CREATED:HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.status(500)
												.message(e.getMessage())
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response<UserResponseDTO>> login(@RequestBody UserRequestDTO request) {
		try {
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.data(onboardingService.login(request))
												.status(200)
												.build(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.status(500)
												.message(e.getMessage())
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
