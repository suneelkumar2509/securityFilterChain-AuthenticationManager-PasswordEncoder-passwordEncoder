package com.springbootsunilblog.springbootsunilblog.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
@Table(name="role")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleid;
	private String role;
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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
	public Roles(Long roleid, String role, List<Users> user) {
		super();
		this.roleid = roleid;
		this.role = role;
		this.user = user;
	}
	public Roles(String role, List<Users> user) {
		super();
		this.role = role;
		this.user = user;
	}
	public Roles() {
		super();
	}
	@Override
	public String toString() {
		return "Roles [roleid=" + roleid + ", role=" + role + ", user=" + user + "]";
	}
	
	
	
	

}
