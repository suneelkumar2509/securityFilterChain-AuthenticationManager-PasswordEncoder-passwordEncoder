package com.springbootsunilblog.springbootsunilblog.DTO;

import com.springbootsunilblog.springbootsunilblog.model.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentDTO {
	
	
	private Long id;
	
	private String name;
	@Size(min = 5, message = "title is too short")
	@Size(max = 100, message = "title is too big")
	@NotBlank(message = " please Enter Body")
	private String  body;
	private String email;
	
	private	Post post;

	public CommentDTO() {
		super();
	}

	public CommentDTO(Long id, String name,
			@Size(min = 5, message = "title is too short") @Size(max = 100, message = "title is too big") @NotBlank(message = " please Enter Body") String body,
			String email, Post post) {
		super();
		this.id = id;
		this.name = name;
		this.body = body;
		this.email = email;
		this.post = post;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", name=" + name + ", body=" + body + ", email=" + email + ", post=" + post
				+ "]";
	}
	
	
	
}
