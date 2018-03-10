package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Class;

public interface ClassRepository extends JpaRepository<Class, Long>{

}
