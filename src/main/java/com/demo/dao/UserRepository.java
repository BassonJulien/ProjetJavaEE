package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
