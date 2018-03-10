package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
