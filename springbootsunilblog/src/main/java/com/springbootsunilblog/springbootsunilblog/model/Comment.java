package com.springbootsunilblog.springbootsunilblog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name", nullable = false)

	private String name;
	@Column(name = "body", nullable = false)

	private String body;
	@Column(name = "email", nullable = false, unique = true)

	private String email;

	@ManyToOne
	private Post post;

	public Comment() {
		super();
	}

	public Comment(long id, String name, String body, String email, Post post) {
		super();
		this.id = id;
		this.name = name;
		this.body = body;
		this.email = email;
		this.post = post;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return "Comment [id=" + id + ", name=" + name + ", body=" + body + ", email=" + email + ", post=" + post + "]";
	}

}
