package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	@Query("select o from Operation o where o.Compte.IdCompte =:x")
	public List<Operation> allOperations(@Param("x") Long idCompte);

}
