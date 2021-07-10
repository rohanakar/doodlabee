package com.doodla.engine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Follow {

	@Id
	@Column(name="FOLLOW_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Users child;

	@ManyToOne
    @JoinColumn(name = "parent_id")
    private Users parent;
	
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Users getChild() {
		return child;
	}

	public Users getParent() {
		return parent;
	}

	public void setChild(Users child) {
		this.child = child;
	}

	public void setParent(Users parent) {
		this.parent = parent;
	}

	public long getId() {
		return id;
	}
	
	public String getFollowerName() {
		return child.getFirstName() + " follows "+ parent.getFirstName();
	}

	
}
