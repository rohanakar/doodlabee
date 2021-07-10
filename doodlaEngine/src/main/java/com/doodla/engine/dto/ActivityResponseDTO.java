package com.doodla.engine.dto;

import java.util.List;
import java.util.Map;

import com.doodla.engine.model.Tips;

public class ActivityResponseDTO {
	
	private String title;
	private Map<String,String> images;
    private List<Tips> tips;
	private String location;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Map<String, String> getImages() {
		return images;
	}
	public void setImages(Map<String, String> images) {
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
