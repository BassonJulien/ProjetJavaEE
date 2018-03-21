package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.*;

public interface CourseRepository extends JpaRepository<Course, Long> {
	@Query(value = "SELECT * FROM intranetPortal.course;", nativeQuery=true)
	public List<Course> getCourseList(); 
	
	@Query(value = "SELECT * FROM intranetPortal.course where intranetPortal.course.teacher_id=:teacher ;", nativeQuery=true)
	public List<Course> getCourseListByTeacher(@Param("teacher") Long teacher); 

	@Modifying
	@Query(value = "SELECT course.name as cname, group_class.name as classname, teacher.name as tname " +
							"FROM course, group_class, teacher " +
							"WHERE (teacher.id_teacher = course.teacher_id) " +
							"AND (course.class_id = group_class.class_id) " +
							"AND teacher.id_teacher=:idid ;"  , nativeQuery=true)
	public List<Object[]> getCourseClassList(@Param("idid")String id); 
	
	
	@Query(value = "SELECT * FROM course WHERE course.name=:courseName LIMIT 1 ;"  , nativeQuery=true)
public Course getCourseFromName(@Param("courseName")String courseName); 
	
}
