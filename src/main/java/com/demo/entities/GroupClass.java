package com.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class GroupClass {
	
	private long classId;
	private String name;
	
	@OneToMany(mappedBy = "sectionStudent")
	private Collection<Student> students;

	@OneToMany(mappedBy = "sectionCourse")
	private Collection<Course> courses;
	

}
