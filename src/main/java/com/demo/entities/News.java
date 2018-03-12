package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News {
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private long idNews;
	private String title;
	private String description;
	private String image;
	private String date;
	private boolean isActive;
	
	public News(String title, String description, String image, String date, boolean isActive) {
		super();
		this.title = title;
		this.description = description;
		this.image = image;
		this.date = date;
		this.isActive = isActive;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdNews() {
		return idNews;
	}

	public void setIdNews(long idNews) {
		this.idNews = idNews;
	}

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
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	
}
