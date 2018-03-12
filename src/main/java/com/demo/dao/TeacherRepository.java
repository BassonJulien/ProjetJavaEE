package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
