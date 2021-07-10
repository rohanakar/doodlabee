package com.doodla.engine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodla.engine.dto.UserRequestDTO;
import com.doodla.engine.dto.UserResponseDTO;
import com.doodla.engine.model.Follow;
import com.doodla.engine.model.Users;
import com.doodla.engine.repositories.FollowRepository;
import com.doodla.engine.repositories.UserRepository;
import com.doodla.engine.utils.NullAwareBeanUtilsBean;
import com.doodla.engine.utils.RequestMapper;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RequestMapper requestMapper;
	
	@Autowired
	private NullAwareBeanUtilsBean beanUtils;
	
	@Autowired
	private FollowRepository followRepository;
	
	@Autowired
	private NotificationService notificationService;
	
	public UserResponseDTO getUser() throws Exception {
		
		String userId = requestMapper.getUserId();
		return getUser(userId);
	}

	public UserResponseDTO updateUser(UserRequestDTO request) throws Exception {
		
		String userId = requestMapper.getUserId();
		Users user= repository.getById(Long.parseLong(userId));
		beanUtils.copyProperties(user, request);
		Users u = repository.save(user);
		
		return new UserResponseDTO(u);
	}

	public void deleteUser() throws Exception {
		
		String userId = requestMapper.getUserId();
		repository.deleteById(Long.parseLong(userId));
		
	}

	public void follow(String parentId) throws Exception {
		String userId = requestMapper.getUserId();
		Users child = repository.getById(Long.parseLong(userId));
		Users parent = repository.getById(Long.parseLong(parentId));
		if(followRepository.countMapping(parent.getId(),child.getId()) == 0) {
			Follow follow = new Follow();
			follow.setChild(child);
			follow.setParent(parent);
			followRepository.save(follow);
			notificationService.notify(null,null);
		}else {
			throw new Exception("Request Already pending");
		}
	}

	public UserResponseDTO getUser(String userId) {
		return new UserResponseDTO(repository.getById(Long.parseLong(userId)));	
	}

	public void acceptFollower(String childId) throws Exception {
		String parentId = requestMapper.getUserId();
		followRepository.updateStatus(Long.parseLong(parentId),Long.parseLong(childId));
		notificationService.notify(null,null);
	}

	public void rejectFollower(long parentId, long childId) {
		followRepository.delete(parentId,childId);
	}
}
