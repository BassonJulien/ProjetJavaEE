package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	//@Query("select o from Student where o.password=:x")
	//public Student student(@Param("x") String password);
	
	@Query(value = "SELECT * FROM Intranet.student WHERE Intranet.student.username=:studentName LIMIT 1;", nativeQuery=true)
	public Student getStudentFromName(@Param("studentName") String studentName); 

		// TODO Auto-generated method stub
		//return null;
	 
}
