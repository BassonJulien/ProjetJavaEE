package com.demo.Metier;

import java.util.List;

import com.demo.entities.*;

public interface IntranetMetierInterface {
	public Student getStudentFromName(String studentName);
	public Teacher getTeacherFromName(String teacherName);
	public List<Teacher>  getAllTeacher();
	public Admin getAdminFromName(String adminName);
	
}
