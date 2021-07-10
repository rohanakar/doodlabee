package com.doodla.engine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodla.engine.dto.ActivityRequestDTO;
import com.doodla.engine.dto.ActivityResponseDTO;
import com.doodla.engine.model.Activity;
import com.doodla.engine.model.Users;
import com.doodla.engine.repositories.ActivityRepository;
import com.doodla.engine.repositories.UserRepository;
import com.doodla.engine.utils.NullAwareBeanUtilsBean;
import com.doodla.engine.utils.RequestMapper;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository repository;
	
	@Autowired
	private RequestMapper requestMapper;	
	
	@Autowired
	private NullAwareBeanUtilsBean beanUtils;
	
	@Autowired
	private UserRepository userRepository;

	public ActivityResponseDTO createActivity(ActivityRequestDTO request) throws Exception {
		
		Activity activity = new Activity();
		String userId = requestMapper.getUserId();
		Users author = userRepository.getById(Long.parseLong(userId));
		beanUtils.copyProperties(activity, request);
		activity.setAuthor(author);
		Activity a = repository.save(activity);
		return null;
	}

}
