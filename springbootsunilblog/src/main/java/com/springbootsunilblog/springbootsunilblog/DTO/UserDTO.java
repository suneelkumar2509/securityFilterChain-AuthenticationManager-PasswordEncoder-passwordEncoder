package com.springbootsunilblog.springbootsunilblog.DTO;

public class UserDTO {
	
	
	public String username;
	public String password;
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
	public UserDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserDTO() {
		super();
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	

}
