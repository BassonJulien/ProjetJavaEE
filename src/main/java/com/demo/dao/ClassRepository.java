package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.GroupClass;

public interface ClassRepository extends JpaRepository<GroupClass, Long>{

}
