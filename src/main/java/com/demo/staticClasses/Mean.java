package com.demo.staticClasses;

public class Mean {
	
	private String courseName;
	private double courseMean;
	public String marks;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCourseMean() {
		return courseMean;
	}
	public void setCourseMean(double courseMean) {
		this.courseMean = courseMean;
	}
	public Mean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mean( double courseMean, String courseName, String marks) {
		super();
		this.courseName = courseName;
		this.courseMean = courseMean;
		this.marks = marks;

	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}

}
