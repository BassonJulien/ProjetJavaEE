package com.demo.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AdminRepository;
import com.demo.dao.StudentRepository;
import com.demo.dao.TeacherRepository;
import com.demo.entities.*;

@Service
@Transactional
public class IntranetMetier implements IntranetMetierInterface{
	@Autowired
	private StudentRepository studentRep ; 
	@Autowired
	private TeacherRepository teacherRep ; 
	@Autowired
	private AdminRepository adminRep ; 
	
	@Override
	public Student getStudentFromName(String studentName) {
		System.out.println("GetStudent FromName");
		if(studentRep.getStudentFromName(studentName) == null) throw new RuntimeException("étudiant non trouvable");
		else return studentRep.getStudentFromName(studentName);
	}
	
	@Override
	public Teacher getTeacherFromName(String teacherName) {
		System.out.println("GetTeacher FromName");
		if(teacherRep.getTeacherFromName(teacherName) == null) throw new RuntimeException("enseignant non trouvable");
		else return teacherRep.getTeacherFromName(teacherName);
	}
	
	@Override
	public List<Teacher>  getAllTeacher() {
		System.out.println("Get all teachers");
		return teacherRep.findAll();
	}

	@Override
	public Admin getAdminFromName(String adminName) {
		System.out.println("GetAdmin FromName");
		if(adminRep.getAdminFromName(adminName) == null) throw new RuntimeException("admin non trouvable");
		else return adminRep.getAdminFromName(adminName);
	}
}
   