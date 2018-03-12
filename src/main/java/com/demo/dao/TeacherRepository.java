package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Teacher;



public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	@Query(value = "SELECT * FROM intranetPortal.teacher WHERE intranetPortal.teacher.username=:teacherName LIMIT 1;", nativeQuery=true)
	public Teacher getTeacherFromName(@Param("teacherName") String teacherName); 
	
}
