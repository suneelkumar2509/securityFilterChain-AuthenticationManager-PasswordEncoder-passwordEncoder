package com.springbootsunilblog.springbootsunilblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootsunilblog.springbootsunilblog.model.Users;


@Repository
public interface UserRepository  extends JpaRepository<Users, Long> {
	
	 

	@Query(value = "select * from users where username=?,email=?",nativeQuery = true)
	 public Users findbyemailorname(String username,String email);

	public Users findByEmail(String username);
	
	
	
}