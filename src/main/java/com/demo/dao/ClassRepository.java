package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.GroupClass;
import com.demo.entities.Student;

public interface ClassRepository extends JpaRepository<GroupClass, Long>{
	@Query(value = "SELECT * FROM intranetPortal.group_class;", nativeQuery=true)
	public List<GroupClass> getGroupClassList(); 
	
	@Query(value = "SELECT * FROM intranetPortal.group_class WHERE intranetPortal.group_class.name=:className LIMIT 1;", nativeQuery=true)
	public GroupClass getClassFromName(@Param("className") String className); 
}
