package com.doodla.engine.dto;

import java.util.List;

import com.doodla.engine.enums.Interest;

public class UserRequestDTO {
	
	private String tagLine;
	private String firstName;
	private String lastName;
	private String email;
	private String gmailUUID;
	private String iosUUID;
	private String phoneUUID;
	private String fbUUID;
	private String phone;
	private String password;
	private String dob;
	private List<Interest> interests;
	private String profileImage;
	private String deviceId;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGmailUUID() {
		return gmailUUID;
	}
	public void setGmailUUID(String gmailUUID) {
		this.gmailUUID = gmailUUID;
	}
	public String getIosUUID() {
		return iosUUID;
	}
	public void setIosUUID(String iosUUID) {
		this.iosUUID = iosUUID;
	}
	public String getPhoneUUID() {
		return phoneUUID;
	}
	public void setPhoneUUID(String phoneUUID) {
		this.phoneUUID = phoneUUID;
	}
	public String getFbUUID() {
		return fbUUID;
	}
	public void setFbUUID(String fbUUID) {
		this.fbUUID = fbUUID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<Interest> getInterests() {
		return interests;
	}
	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
}
