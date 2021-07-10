package com.doodla.engine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doodla.engine.dto.MessageRequestDTO;
import com.doodla.engine.dto.PaginationRequestDTO;
import com.doodla.engine.dto.Response;

@RestController
@RequestMapping("/v1/message")
public class MessageController {

	@PostMapping(value = "/create")
	public ResponseEntity<Response> createMessage(@RequestBody MessageRequestDTO request) {
		return null;
	}
	
	@DeleteMapping(value = "/{messageId}")
	public ResponseEntity<Response> deleteActivity(@PathVariable("messageId") String messageId) {
		return null;
	}
	
	@GetMapping(value = "/messages")
	public ResponseEntity<Response> getMessages(@RequestBody PaginationRequestDTO request) {
		return null;
	}
}
