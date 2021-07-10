package com.doodla.engine.dto;

import java.util.List;

import com.doodla.engine.model.Images;
import com.doodla.engine.model.Tips;

public class ActivityRequestDTO {
	
	private String title;
	private List<Images> images;
    private List<Tips> tips;
	private String location;
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

	
}
