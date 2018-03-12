package com.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long courseId;
	private String name;
	private String day;
	private String hours;
	
	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getHours() {
		return hours;
	}


	public void setHours(String hours) {
		this.hours = hours;
	}


	@ManyToOne
	@JoinColumn(name="teacherId")
	private Teacher teacher;
	@ManyToOne
	@JoinColumn(name="classId")
	private GroupClass classCourse;
	

	public Long getCourseId() {
		return courseId;
	}


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


	public GroupClass getClassCourse() {
		return classCourse;
	}


	public void setClassCourse(GroupClass classCourse) {
		this.classCourse = classCourse;
	}


	public Collection<Mark> getMarks() {
		return marks;
	}


	public void setMarks(Collection<Mark> marks) {
		this.marks = marks;
	}


	public Course(String name, Teacher teacher, GroupClass classCourse) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.classCourse = classCourse;
	}
	
	
	
}
