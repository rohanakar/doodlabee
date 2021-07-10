package com.doodla.engine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Images {

	@Id
	@Column(name="IMAGE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity;
	
	private String base64;
	
	private boolean coverImage;

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

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public boolean isCoverImage() {
		return coverImage;
	}

	public void setCoverImage(boolean coverImage) {
		this.coverImage = coverImage;
	}
	
	
	
	
	
}
