//package com.doodla.engine.builder;
//
//import java.util.List;
//
//import com.doodla.engine.enums.Interest;
//import com.doodla.engine.model.User;
//
//public class UserBuilder {
//	
//	private String tagLine;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String gmailUUID;
//	private String iosUUID;
//	private String phoneUUID;
//	private String fbUUID;
//	private String phone;
//	private String password;
//	private String dob;
//	private String profileImage;
//	private List<Interest> interests;
//
//	public UserBuilder tagLine(String tagLine){
//		 this.tagLine = tagLine;
//		 return this;
//	}
//	public UserBuilder firstName(String firstName){
//		 this.firstName = firstName;
//		 return this;
//	}
//	public UserBuilder lastName(String lastName){
//		 this.lastName = lastName;
//		 return this;
//	}
//	public UserBuilder email(String email){
//		 this.email = email;
//		 return this;
//	}
//	
//	public UserBuilder gmailUUID(String gmailUUID){
//		 this.gmailUUID = gmailUUID;
//		 return this;
//	}
//	public UserBuilder iosUUID(String iosUUID){
//		 this.iosUUID = iosUUID;
//		 return this;
//	}
//	public UserBuilder phoneUUID(String phoneUUID){
//		 this.phoneUUID = phoneUUID;
//		 return this;
//	}
//	public UserBuilder fbUUID(String fbUUID){
//		 this.fbUUID = fbUUID;
//		 return this;
//	}
//	public UserBuilder phone(String phone){
//		 this.phone = phone;
//		 return this;
//	}
//	public UserBuilder password(String password){
//		 this.password = password;
//		 return this;
//	}
//	public UserBuilder profileImage(String profileImage){
//		 this.profileImage = profileImage;
//		 return this;
//	}
//	public UserBuilder interests(List<Interest> interests){
//		 this.interests = interests;
//		 return this;
//	}
//	public UserBuilder dob(String dob){
//		 this.dob = dob;
//		 return this;
//	}
//	public User build() {
//		User u = new User();
//		u.setFbUUID(fbUUID);
//		u.setFirstName(firstName);
//		u.setDob(dob);
//		u.setEmail(email);
//		u.setGmailUUID(gmailUUID);
//		u.setIosUUID(iosUUID);
//		u.setLastName(lastName);
//		u.setPassword(password);
//		u.setPhone(phone);
//		u.setPhoneUUID(phoneUUID);
//		u.setTagLine(tagLine);
//		u.setProfileImage(profileImage);
//		u.setInterests(interests);
//		return u;
//	}
//}
