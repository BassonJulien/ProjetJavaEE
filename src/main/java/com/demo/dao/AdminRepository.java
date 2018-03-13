package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query(value = "SELECT * FROM intranetPortal.admin WHERE intranetPortal.admin.username=:adminName LIMIT 1;", nativeQuery=true)
	public Admin getAdminFromName(@Param("adminName") String adminName); 
}
