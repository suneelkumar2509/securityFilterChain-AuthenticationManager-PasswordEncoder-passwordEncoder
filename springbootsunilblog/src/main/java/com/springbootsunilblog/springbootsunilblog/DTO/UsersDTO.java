package com.springbootsunilblog.springbootsunilblog.DTO;

import java.util.List;

import com.springbootsunilblog.springbootsunilblog.model.Roles;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsersDTO {
	
	
	private Long userid;
	
	@Size(min = 5, message = "title is too short")
	@Size(max = 50, message = "title is too big")
	@NotBlank(message = " enter valide email")
	private String email;
	
	@Size(min = 5, message = "title is too short")
	@Size(max = 50, message = "title is too big")
	@NotBlank(message = " enter valide username")	
	private String username;
	
	@NotBlank(message = " enter valide password")	
	private String	password;
	
	
	private List<Roles> roles;


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Roles> getRoles() {
		return roles;
	}


	public void setRoles(List<Roles> roleslist) {
		this.roles = roleslist;
	}


	public UsersDTO(Long userid,
			@Size(min = 5, message = "title is too short") @Size(max = 50, message = "title is too big") @NotBlank(message = " enter valide email") String email,
			@Size(min = 5, message = "title is too short") @Size(max = 50, message = "title is too big") @NotBlank(message = " enter valide username") String username,
			@NotBlank(message = " enter valide password") String password, List<Roles> roles) {
		super();
		this.userid = userid;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}


	public UsersDTO() {
		super();
	}


	@Override
	public String toString() {
		return "UsersDTO [userid=" + userid + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", roles=" + roles + "]";
	}

	 
	 
	 
}
