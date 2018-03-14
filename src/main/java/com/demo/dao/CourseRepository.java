package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.*;

public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query(value = "SELECT * FROM intranetPortal.course;", nativeQuery=true)
	public List<Course> getCourseList(); 
	
	@Query(value = "SELECT * FROM intranetPortal.course where intranetPortal.course.teacher_id=:teacher ;", nativeQuery=true)
	public List<Course> getCourseListByTeacher(@Param("teacher") Long teacher); 
}
