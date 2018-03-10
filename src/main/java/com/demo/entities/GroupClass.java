package com.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GroupClass {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private long classId;
	

	private String name;
	
	@OneToMany(mappedBy = "studentClass")
	private Collection<Student> students;

	@OneToMany(mappedBy = "classCourse")
	private Collection<Course> courses;
	
	public GroupClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupClass(String name, Collection<Student> students, Collection<Course> courses) {
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
