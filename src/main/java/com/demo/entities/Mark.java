package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Mark implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue
	private long idMark;
	private long idStudent;
	private long idModule;
	private float mark;
	
	public Mark(long idStudent, long idModule, float mark) {
		super();
		this.idStudent = idStudent;
		this.idModule = idModule;
		this.mark = mark;
	}
	public Mark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(long idStudent) {
		this.idStudent = idStudent;
	}
	public long getIdModule() {
		return idModule;
	}
	public void setIdModule(long idModule) {
		this.idModule = idModule;
	}
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
	
}
