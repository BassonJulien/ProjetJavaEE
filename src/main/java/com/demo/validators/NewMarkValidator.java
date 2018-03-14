package com.demo.validators;

import javax.validation.constraints.Size;

public class NewMarkValidator {

	private String courseClass;

	
	private String studentClass;
	
	private int mark;
	public String getStudentClass() {
		return studentClass;
	}


	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}


	public int getMark() {
		return mark;
	}


	public void setMark(int mark) {
		this.mark = mark;
	}


	public String getCourseClass() {
		return courseClass;
	}
	

	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}
	
	
}
