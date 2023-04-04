package com.springbootsunilblog.springbootsunilblog.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Post {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@Column(name = "description", nullable = false, unique = true)
	private String description;
	
	@Column(name = "content", nullable = false, unique = true)
	private String content;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private Set<Comment> comment =new  HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Post() {
		super();
	}

	public Post(Long id, String title, String description, String content, Set<Comment> comment) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", comment=" + comment + "]";
	}

	
}
