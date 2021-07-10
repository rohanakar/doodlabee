package com.doodla.engine.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Activity {
	
	@Id
	@Column(name="ACTIVITY_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users author;
	 
	private String title;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
	private List<Images> images;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
    private List<Tips> tips;
	
	private String location;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
	private List<Likes> likes;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
	private List<Comments> comments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<Tips> getTips() {
		return tips;
	}

	public void setTips(List<Tips> tips) {
		this.tips = tips;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
	
}
