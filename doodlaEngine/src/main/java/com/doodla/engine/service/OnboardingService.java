package com.doodla.engine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.doodla.engine.dto.UserRequestDTO;
import com.doodla.engine.dto.UserResponseDTO;
import com.doodla.engine.model.Devices;
import com.doodla.engine.model.Users;
import com.doodla.engine.repositories.DeviceRepository;
import com.doodla.engine.repositories.UserRepository;
import com.doodla.engine.utils.JwtTokenService;
import com.doodla.engine.utils.NullAwareBeanUtilsBean;

@Service
public class OnboardingService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private JwtTokenService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private NullAwareBeanUtilsBean beanUtils;
	
	public UserResponseDTO registerUser(UserRequestDTO request) throws Exception {
		// TODO Auto-generated method stub
		if(!StringUtils.hasText(request.getPassword()) || !StringUtils.hasText(request.getEmail())) {
			throw new Exception("email/password can not be empty");
		}
		Users user = new Users();
		beanUtils.copyProperties(user, request);
		if(repository.countEmail(user.getEmail()) != 0)
			throw new Exception("email already Present");
		encryptPassword(user);
		Users u = repository.save(user);
		String token = jwtService.generateToken(u);
		UserResponseDTO userResponseDTO = new UserResponseDTO(u);
		userResponseDTO.setAccessToken(token);
		userResponseDTO.setFirstTime(true);
		return userResponseDTO;
	}
	
	private void encryptPassword(Users user) {
		if(StringUtils.hasText(user.getPassword()))
			user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

	public UserResponseDTO loginSSO(UserRequestDTO request) throws Exception {
		
		Devices device = deviceRepository.findById(request.getDeviceId()).orElse(new Devices());
		device.setDevice_UUID(request.getDeviceId());
		device.setLoggedIn(true);
		
		Users user = null;
		if(StringUtils.hasText(request.getFbUUID())) {
			user = repository.getFromFB(request.getFbUUID());
		}else if(StringUtils.hasText(request.getGmailUUID())) {
			user = repository.getFromGmail(request.getGmailUUID());
		}else if(StringUtils.hasText(request.getIosUUID())) {
			user = repository.getFromIOS(request.getIosUUID());
		}else if(StringUtils.hasText(request.getPhoneUUID())) {
			user = repository.getFromPhone(request.getPhoneUUID());
		}
		if(user == null) {	
			user = new Users();
			boolean firstTime = true;
			if(repository.countEmail(request.getEmail()) != 0) {
				user = repository.getFromEmail(request.getEmail());
				if(invalidRequest(user,request)) {
					throw new Exception("The UUID's have already been assigned and can't be updated");
				}
				firstTime = false;
			}
			beanUtils.copyProperties(user, request);
			user.getDevices().add(device);
			device.getUsers().add(user);
			Users u = repository.save(user);
			String token = jwtService.generateToken(u);
			UserResponseDTO userResponseDTO = new UserResponseDTO(u);
			userResponseDTO.setAccessToken(token);
			userResponseDTO.setFirstTime(firstTime);
			return userResponseDTO;
		}
		String token = jwtService.generateToken(user);
		UserResponseDTO userResponseDTO = new UserResponseDTO(user);
		userResponseDTO.setAccessToken(token);
		userResponseDTO.setFirstTime(false);
		user.getDevices().add(device);
		device.getUsers().add(user);
		repository.save(user);
		return userResponseDTO;
	}

	private boolean invalidRequest(Users user, UserRequestDTO request) {
		// these fields will be either different or null in user object.
		if(StringUtils.hasText(request.getFbUUID()) && StringUtils.hasText(user.getFbUUID())) {
			return true;
		}
		if(StringUtils.hasText(request.getGmailUUID()) && StringUtils.hasText(user.getGmailUUID())) {
			return true;
		}
		
		if(StringUtils.hasText(request.getIosUUID()) && StringUtils.hasText(user.getIosUUID())) {
			return true;
		}
		
		if(StringUtils.hasText(request.getPhoneUUID()) && StringUtils.hasText(user.getPhoneUUID())) {
			return true;
		}
		return false;
	}

	public UserResponseDTO login(UserRequestDTO request) throws Exception {
		
		if(!StringUtils.hasText(request.getPassword()) || !StringUtils.hasText(request.getEmail())) {
			throw new Exception("email/password can not be empty");
		}
		
		Users u = repository.getFromEmail(request.getEmail());
		if(u==null) {
			throw new Exception("Invalid email");
		}
		if(!passwordEncoder.matches(request.getPassword(), u.getPassword())) {
			throw new Exception("Invalid password");
		}
		String token = jwtService.generateToken(u);
		UserResponseDTO userResponseDTO = new UserResponseDTO(u);
		userResponseDTO.setAccessToken(token);
		return userResponseDTO;
	}

}
