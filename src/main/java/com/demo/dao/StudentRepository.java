package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
