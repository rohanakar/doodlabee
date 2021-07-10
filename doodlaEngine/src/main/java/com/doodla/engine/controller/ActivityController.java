package com.doodla.engine.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doodla.engine.builder.ResponseBuilder;
import com.doodla.engine.dto.ActivityRequestDTO;
import com.doodla.engine.dto.ActivityResponseDTO;
import com.doodla.engine.dto.PaginationRequestDTO;
import com.doodla.engine.dto.Response;
import com.doodla.engine.service.ActivityService;

@RestController
@RequestMapping("/v1/activity")
public class ActivityController {
	
	@Autowired
	private ActivityService service;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Response<ActivityResponseDTO>> createActivity(@RequestBody ActivityRequestDTO request) {
		try {
			return new ResponseEntity<Response<ActivityResponseDTO>>(new ResponseBuilder<ActivityResponseDTO>()
												.data(service.createActivity(request))
												.status(201)
												.build(),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<Response<ActivityResponseDTO>>(new  ResponseBuilder<ActivityResponseDTO>()
												.status(500)
												.message(e.getMessage())
												.error(e.toString())
												.build(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping(value = "/update/{activityId}")
	public ResponseEntity<Response> createActivity(@PathVariable("activityId") String activityId,
												@RequestBody ActivityRequestDTO request) {
		return null;
	}
	
	@GetMapping(value = "/activities")
	public ResponseEntity<Response> getActivities(@RequestBody PaginationRequestDTO request) {
		return null;
	}
	
	@PostMapping(value = "/like/{activityId}")
	public ResponseEntity<Response> likeActivity(@PathVariable("activityId") String activityId) {
		return null;
	}
	
	@PostMapping(value = "/comment/{activityId}")
	public ResponseEntity<Response> commentOnActivity(@PathVariable("activityId") String activityId,
													@RequestBody LinkedHashMap<String,String> request) {
		return null;
	}
	
	@DeleteMapping(value = "/{activityId}")
	public ResponseEntity<Response> deleteActivity(@PathVariable("activityId") String activityId) {
		return null;
	}
}