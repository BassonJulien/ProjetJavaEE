package com.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Class {
	
	private long classId;
	private String name;
	
	@OneToMany(mappedBy = "sectionStudent")
	private Collection<Student> students;

	@OneToMany(mappedBy = "sectionCourse")
	private Collection<Course> courses;
	
	
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Class(String name, Collection<Student> students, Collection<Course> courses) {
		super();
		this.name = name;
		this.students = students;
		this.courses = courses;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Collection<Student> getStudents() {
		return students;
	}


	public void setStudents(Collection<Student> students) {
		this.students = students;
	}


	public Collection<Course> getCourses() {
		return courses;
	}


	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	
}
