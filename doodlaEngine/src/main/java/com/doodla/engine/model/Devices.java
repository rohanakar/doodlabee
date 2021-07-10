package com.doodla.engine.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Devices")
public class Devices {
	
	@Id
	@Column(name = "DEVICE_ID")
	private String device_UUID;
	
	@ManyToMany(mappedBy = "devices",  cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
	private Set<Users> users = new HashSet<>();
	
	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	private boolean loggedIn;

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getDevice_UUID() {
		return device_UUID;
	}

	public void setDevice_UUID(String device_UUID) {
		this.device_UUID = device_UUID;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	

}
