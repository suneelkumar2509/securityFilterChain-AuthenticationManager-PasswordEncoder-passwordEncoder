package com.springbootsunilblog.springbootsunilblog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsunilblog.springbootsunilblog.DTO.CovidDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.PostDTO;
import com.springbootsunilblog.springbootsunilblog.exception.Blogexeceptionhandler;
import com.springbootsunilblog.springbootsunilblog.exception.ResourceNotFoundException;
import com.springbootsunilblog.springbootsunilblog.model.Post;
import com.springbootsunilblog.springbootsunilblog.model.Users;
import com.springbootsunilblog.springbootsunilblog.service.UsersService;
import com.springbootsunilblog.springbootsunilblog.service.postService;

@RestController
@RequestMapping("/blog/api")
public class postController {

	@Autowired
	private postService Service;
	@Autowired
	private UsersService usersService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin/posts")
	public ResponseEntity<?> addpost(@Validated @RequestBody PostDTO postdto, BindingResult binres) {
		if (binres.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : binres.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);
		} else {

			PostDTO st = Service.addpost(postdto);
			return new ResponseEntity<PostDTO>(st, HttpStatus.OK);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/admin/posts/{id}")
	public ResponseEntity<String> deletepost(@PathVariable("id") Long id) throws ResourceNotFoundException {

		if (Service.existingpost(id) == true) {
			String error = " post deleted succesfull";
			return new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
		} else {

			Service.deletepost(id);
			String error = "  Error while deleting post ";
			return new ResponseEntity<String>(error, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/admin/posts/{id}")
	public ResponseEntity<Post> updatepost(@PathVariable("id") Long id, @RequestBody Post poss) {

		poss.setId(id);
		Post st = Service.updatepost(poss);
		return new ResponseEntity<Post>(st, HttpStatus.OK);
	}

	@GetMapping("/user/posts")
	public ResponseEntity<List<PostDTO>> getallpost(
			@RequestParam(value = "Pageno", defaultValue = "0", required = false) Integer pageno,
			@RequestParam(value = "pagesize", defaultValue = "4", required = false) Integer pagesize,
			@RequestParam(value = "sotrby", defaultValue = "id", required = false) String sotrby,
			@RequestParam(value = "sotrdsc", defaultValue = "asc", required = false) String sotrdsc) {
		List<PostDTO> postss = Service.getallpost(pageno, pagesize, sotrby, sotrdsc);

		return new ResponseEntity<List<PostDTO>>(postss, HttpStatus.OK);

	}

	@GetMapping("/user/covids")
	public ResponseEntity<?> getallcoviddata() {

		return new ResponseEntity<CovidDTO[]>(Service.getcoviddata(), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('usere')")
	@GetMapping("/user/user")
	public ResponseEntity<?> getuserbynameoremail(@PathVariable("username") String username,
			@PathVariable("email") String email) {

		Users us;
		try {
			us = usersService.getuserbynameoremail(username, email);

		} catch (ResourceNotFoundException e) {
			throw new Blogexeceptionhandler("user not found please enter valede information ");

		}
		return new ResponseEntity<Users>(us, HttpStatus.OK);

	}

}
