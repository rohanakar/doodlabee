package com.doodla.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodla.engine.builder.ResponseBuilder;
import com.doodla.engine.dto.Response;
import com.doodla.engine.dto.UserResponseDTO;
import com.doodla.engine.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/user")
	public ResponseEntity<Response<UserResponseDTO>> getUser() {
		try {
			UserResponseDTO response = service.getUser();
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
					.status(200)
					.data(response)
					.build(),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.message(e.getMessage())
												.status(500)
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<Response<UserResponseDTO>> getPublicProfile(@PathVariable("id") String id) {
		try {
			UserResponseDTO response = service.getUser(id);
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
					.status(200)
					.data(response)
					.build(),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Response<UserResponseDTO>>(new ResponseBuilder<UserResponseDTO>()
												.message(e.getMessage())
												.status(500)
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value = "/follow/{parentId}")
	public ResponseEntity<Response> followUser(@PathVariable("parentId")  String parentId) {
		try {
			service.follow(parentId);
			return new ResponseEntity<Response>(new ResponseBuilder()
					.status(200)
					.build(),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Response>(new ResponseBuilder()
												.message(e.getMessage())
												.status(500)
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/follow/accept/{childId}")
	public ResponseEntity<Response> acceptFollower(@PathVariable("childId")  String childId) {
		try {
			service.acceptFollower(childId);
			return new ResponseEntity<Response>(new ResponseBuilder()
					.status(200)
					.build(),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Response>(new ResponseBuilder()
												.message(e.getMessage())
												.status(500)
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/follow/reject")
	public ResponseEntity<Response> rejectFollower(@RequestParam("childId")long childId,@RequestParam("parentId")long parentId) {
		try {
			service.rejectFollower(parentId,childId);
			return new ResponseEntity<Response>(new ResponseBuilder()
					.status(200)
					.build(),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Response>(new ResponseBuilder()
												.message(e.getMessage())
												.status(500)
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/user")
	public ResponseEntity<Response> deleteUser() {
		try {
			service.deleteUser();
			return new ResponseEntity<Response>(new ResponseBuilder()
					.status(200)
					.build(),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Response>(new ResponseBuilder()
												.message(e.getMessage())
												.status(500)
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@PostMapping(value = "/register")
//	public ResponseEntity<String> registerUser(@RequestBody User user) {
//		try{
//			String token = service.registerUser(user);
//			return new ResponseEntity<String>(token, HttpStatus.CREATED);
//		}catch(IllegalArgumentException ex) {
//			return new ResponseEntity<String>(ex.toString(),HttpStatus.BAD_REQUEST);
//		}
//		catch(Exception e) {
//			return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@PostMapping(value = "/unregister")
//	public ResponseEntity<String> deRegisterUser(@RequestBody User user) {
//		try{
//			service.removeUser(user);
//			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		}catch(IllegalArgumentException ex) {
//			return new ResponseEntity<String>(ex.toString(),HttpStatus.BAD_REQUEST);
//		}
//		catch(Exception e) {
//			return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	
}
