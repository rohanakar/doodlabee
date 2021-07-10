package com.doodla.engine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Likes {

	@Id
	@Column(name = "LIKE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
