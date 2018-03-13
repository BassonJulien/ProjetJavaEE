package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	//@Query("select o from Student where o.password=:x")
	//public Student student(@Param("x") String password);
	
	@Query(value = "SELECT * FROM intranetPortal.student WHERE intranetPortal.student.username=:studentName LIMIT 1;", nativeQuery=true)
	public Student getStudentFromName(@Param("studentName") String studentName); 
	
	@Query(value = "SELECT * FROM intranetPortal.student WHERE intranetPortal.student.name=:username LIMIT 1;", nativeQuery=true)
	public Student getStudentFromUsername(@Param("username") String username); 

	@Query(value = "select student.name  as sname, group_class.name as cname " + 
			"from student, group_class " + 
			"where (student.class_id = group_class.class_id) " + 
			" ;", nativeQuery=true)
	public List<Object[]>  getStudentFromClassName(); 

		// TODO Auto-generated method stub
		//return null;
	 
}
