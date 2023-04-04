package com.springbootsunilblog.springbootsunilblog.DTO;

import java.util.HashSet;
import java.util.Set;

import com.springbootsunilblog.springbootsunilblog.model.Comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostDTO {

	private Long id;

	@Size(min = 5, message = "title is too short")
	@Size(max = 50, message = "title is too big")
	@NotBlank(message = " enter valide title")
	private String title;

	@Size(min = 5, message = "description is too short")
	@Size(max = 100, message = "description is too big")
	@NotBlank(message = " enter valide description")
	private String description;

	private String content;

	private Set<Comment> comment = new HashSet<>();

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

	public PostDTO(Long id,
			@Size(min = 5, message = "title is too short") @Size(max = 50, message = "title is too big") @NotBlank(message = " enter valide title") String title,
			@Size(min = 5, message = "description is too short") @Size(max = 100, message = "description is too big") @NotBlank(message = " enter valide description") String description,
			String content, Set<Comment> comment) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.comment = comment;
	}

	public PostDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PostDTO [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", comment=" + comment + "]";
	}

}
