package com.springbootsunilblog.springbootsunilblog.model;

import java.util.List;

import com.springbootsunilblog.springbootsunilblog.DTO.RolesDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String email;
	private String username;
	private String	password;
	@ManyToMany
	 @JoinTable( name = "user_role",joinColumns = {
		            @JoinColumn(name = "roleid")
		        },
		        inverseJoinColumns = {
		            @JoinColumn(name = "userid")
		        }
		    )
	private  List<Roles> roles;
	
	
	
	
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
	
	
	
	public Users(Long userid, String email, String username, String password, List<Roles> roles) {
		super();
		this.userid = userid;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public Users(String email, String username, String password, List<Roles> roles) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	
	
	
	
	

}
