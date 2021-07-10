package com.doodla.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doodla.engine.builder.ResponseBuilder;
import com.doodla.engine.dto.Response;
import com.doodla.engine.dto.UserRequestDTO;
import com.doodla.engine.dto.UserResponseDTO;
import com.doodla.engine.service.UserService;

@Controller
@RequestMapping("v1/post-onbaording")
public class PostOnboardingController {
	
	@Autowired
	private UserService userService;
	
	@PatchMapping("/user/update")
	public ResponseEntity<Response<UserResponseDTO>> updateUser(@RequestBody UserRequestDTO request) {
		try {
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.data(userService.updateUser(request))
												.status(200)
												.build(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Response<UserResponseDTO>>(new  ResponseBuilder<UserResponseDTO>()
												.status(500)
												.message(e.getMessage())
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/user/reset-password/email")
	public ResponseEntity<Response> resetPassword(@RequestBody UserRequestDTO request) {
		return null;
	}
	
	@PatchMapping("/user/updatePassword/{code}")
	public ResponseEntity<Response> updatePassword(@PathVariable("code") String code) {
		return null;
	}
	
}