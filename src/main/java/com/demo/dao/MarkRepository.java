package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long>{

}
