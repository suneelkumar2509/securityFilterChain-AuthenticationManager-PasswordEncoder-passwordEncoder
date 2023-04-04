package com.springbootsunilblog.springbootsunilblog.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsunilblog.springbootsunilblog.DTO.CommentDTO;
import com.springbootsunilblog.springbootsunilblog.exception.ResourceNotFoundException;
import com.springbootsunilblog.springbootsunilblog.service.CommentService;

@RestController
@RequestMapping("/blog/api")
public class CommentController {

	@Autowired
	private CommentService commService;
	

	@PostMapping("/posts/{postid}/comments")
	public ResponseEntity<?> addcomment(@RequestBody CommentDTO commentdto, @PathVariable Long postid)
			throws ResourceNotFoundException {

		CommentDTO commentdtoadd = commService.addcomment(postid, commentdto);
		return new ResponseEntity<CommentDTO>(commentdtoadd, HttpStatus.CREATED);
	}
	
	
	
	

}
