package com.doodla.engine.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
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
	private String profileImage;
	@ElementCollection
	@CollectionTable(name="interests", joinColumns=@JoinColumn(name="user_id"))
	@Column(name="interest")
	private List<String> interests;
	
	/*
	 * This user is mapped by child in Follow table .
	 *  So the users this user follows would be found in this list.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "child")
	private List<Follow> children;
	 
	/*
	 * This user is mapped by child in Follow table .
	 *  So the followers of this user would be found in this list.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Follow> parents;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	private List<Activity> activities;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Likes> likes;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Comments> comments;
	
	@ManyToMany( cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
	private Set<Devices> devices = new HashSet<Devices>();
	

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Follow> getChildren() {
		return children;
	}

	public List<Follow> getParents() {
		return parents;
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
	
	public void setChildren(List<Follow> children) {
		this.children = children;
	}

	public void setParents(List<Follow> parents) {
		this.parents = parents;
	}

	public long getId() {
		return id;
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
	
	public String getName() {
		return this.firstName +" "+ this.lastName;
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
	@JsonIgnore
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

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public Set<Devices> getDevices() {
		return devices;
	}

	public void setDevices(Set<Devices> devices) {
		this.devices = devices;
	}
	
}
