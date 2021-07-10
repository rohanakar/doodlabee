package com.doodla.engine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tips {

	@Id
	@Column(name = "TIP_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;

	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity;
	
	private String tip;
	
	private String price;
	
	private String security;
	
	private String recommendation;
	
	private String mustDo;

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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getMustDo() {
		return mustDo;
	}

	public void setMustDo(String mustDo) {
		this.mustDo = mustDo;
	}
	
	
}
