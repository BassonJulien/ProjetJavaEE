package com.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private long idTeacher;
	public long getIdTeacher() {
		return idTeacher;
	}

	private String name;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "teacher")
	private Collection<Course> courses;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	public Teacher(String name, String username, String password, Collection<Course> courses) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.courses = courses;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
