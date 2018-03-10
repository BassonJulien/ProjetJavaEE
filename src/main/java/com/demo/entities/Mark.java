package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;


@Entity
public class Mark implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private long idMark;
	@ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
	
	@ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
	
	private float mark;

	public Mark(Student student, Course course, float mark) {
		super();
		this.student = student;
		this.course = course;
		this.mark = mark;
	}

	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}
	
}