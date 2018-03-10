package com.demo.entities;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Course {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long classId;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="teacherId")
	private Teacher teacher;
	@ManyToOne
	@JoinColumn(name="classId")
	private Class classCourse;
	

	@OneToMany(mappedBy = "course")
	private Collection<Mark> marks;	
	

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Teacher getTeacher() {
		return teacher;
	}


	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


	public Class getClassCourse() {
		return classCourse;
	}


	public void setClassCourse(Class classCourse) {
		this.classCourse = classCourse;
	}


	public Collection<Mark> getMarks() {
		return marks;
	}


	public void setMarks(Collection<Mark> marks) {
		this.marks = marks;
	}


	public Course(String name, Teacher teacher, Class classCourse) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.classCourse = classCourse;
	}
	
	
	
}
