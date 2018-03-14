package com.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private long idStudent;
	public long getIdStudent() {
		return idStudent;
	}

	private String name;
	private String username;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="classId")
	private GroupClass studentClass;
	
	@OneToMany(mappedBy = "student")
	private Collection<Mark> marks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String username, String password, GroupClass studentClass) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.studentClass = studentClass;
	}

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

	public GroupClass getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(GroupClass studentClass) {
		this.studentClass = studentClass;
	}

	public Collection<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Collection<Mark> marks) {
		this.marks = marks;
	}
	public Long getId() {
		return this.idStudent;
	}

	
}
