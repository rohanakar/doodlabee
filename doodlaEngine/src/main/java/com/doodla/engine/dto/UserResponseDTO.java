package com.doodla.engine.dto;

import java.util.List;

import com.doodla.engine.enums.Interest;
import com.doodla.engine.model.Users;

public class UserResponseDTO {
	
	private String accessToken;
	private boolean firstTime;
	private long id;
	private String tagLine;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String dob;
	private String profileImage;
	private List<Interest> interests;
	private int countries;
	private int cities;
	private int experiences;
	
	public int getCountries() {
		return countries;
	}
	public void setCountries(int countries) {
		this.countries = countries;
	}
	public int getCities() {
		return cities;
	}
	public void setCities(int cities) {
		this.cities = cities;
	}
	public int getExperiences() {
		return experiences;
	}
	public void setExperiences(int experiences) {
		this.experiences = experiences;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserResponseDTO(Users user) {
		this.dob = user.getDob();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.setPhone(user.getPhone());
		this.profileImage = user.getProfileImage();
		this.tagLine = user.getTagLine();
		
//		this.followers = user.getParents()==null?new HashMap<Long,String>() : user.getParents().stream()
//							.map(follow->follow.getChild())
//							.collect(Collectors.toMap(User::getId,User::getName));
//		this.following = user.getChildren()==null?new HashMap<Long,String>() :user.getChildren().stream()
//				.map(follow->follow.getParent())
//				.collect(Collectors.toMap(User::getId,User::getName));
		this.id = user.getId();
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public boolean isFirstTime() {
		return firstTime;
	}
	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}
	public String getTagLine() {
		return tagLine;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getDob() {
		return dob;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public List<Interest> getInterests() {
		return interests;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
