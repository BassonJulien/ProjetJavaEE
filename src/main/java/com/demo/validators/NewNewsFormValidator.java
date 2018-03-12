package com.demo.validators;

import javax.validation.constraints.Size;

public class NewNewsFormValidator {

	@Size(min = 1, max = 255, message = "Please enter between {min} and {max} characters.")
	private String title;
	
	@Size(min = 1, max = 255, message = "Please enter between {min} and {max} characters.")
	private String description;
	
	private String image;
	
	private String date;
	
	private boolean active;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
