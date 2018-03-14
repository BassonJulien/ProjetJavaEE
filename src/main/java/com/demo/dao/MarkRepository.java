package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Mark;
import com.demo.entities.Student;
import com.demo.staticClasses.Mean;

public interface MarkRepository extends JpaRepository<Mark, Long>{

	@Query(value = "select (sum(mark.mark)/count(mark)) as mean, course.name "
			+ " from mark inner join course on course.course_id = mark.course_id "
			+ " where mark.student_id=:studentId group by mark.course_id ;" 
			, nativeQuery=true)
	public List<Object[]> getStudentsMeanFromId(@Param("studentId") Long studentId); 
	
	@Query(value = "SELECT mark.mark FROM mark inner join course on "
			+ "course.course_id=mark.course_id  WHERE course.name=:courseName "
			+ "and mark.student_id=:studentId ;" 
			, nativeQuery=true)
	public List<Float> getStudentsMarksFromCourseName(@Param("courseName") String courseName, @Param("studentId") Long studentId ); 

}
