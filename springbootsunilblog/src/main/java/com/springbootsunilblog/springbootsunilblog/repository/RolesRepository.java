package com.springbootsunilblog.springbootsunilblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootsunilblog.springbootsunilblog.DTO.RolesDTO;
import com.springbootsunilblog.springbootsunilblog.model.Roles;
@Repository
public interface RolesRepository  extends JpaRepository<Roles, Long>{
	
	
	public Roles findByrole(String role);
	

}
