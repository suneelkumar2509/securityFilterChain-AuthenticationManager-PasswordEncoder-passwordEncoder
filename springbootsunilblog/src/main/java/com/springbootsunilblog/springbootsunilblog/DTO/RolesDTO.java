package com.springbootsunilblog.springbootsunilblog.DTO;

import java.util.List;

import com.springbootsunilblog.springbootsunilblog.model.Users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RolesDTO {
	
	private Long roleid;
	
	@Size(min = 5, message = "title is too short")
	@Size(max = 50, message = "title is too big")
	@NotBlank(message = " enter valide email")
	private String role;
	
	List<Users> user;

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public RolesDTO(Long roleid,
			@Size(min = 5, message = "title is too short") @Size(max = 50, message = "title is too big") @NotBlank(message = " enter valide email") String role,
			List<Users> user) {
		super();
		this.roleid = roleid;
		this.role = role;
		this.user = user;
	}

	public RolesDTO() {
		super();
	}

	@Override
	public String toString() {
		return "RolesDTO [roleid=" + roleid + ", role=" + role + ", user=" + user + "]";
	}
	
	
	
	
}
