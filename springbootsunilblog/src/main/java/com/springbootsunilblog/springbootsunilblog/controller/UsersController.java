package com.springbootsunilblog.springbootsunilblog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsunilblog.springbootsunilblog.DTO.RolesDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.UserDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.UsersDTO;
import com.springbootsunilblog.springbootsunilblog.model.Roles;
import com.springbootsunilblog.springbootsunilblog.service.UsersService;

@RestController
@RequestMapping("/blog/api")
public class UsersController {
	
	
	@Autowired
	private UsersService usersService;
	
	
	
	@PostMapping("/addusers")
	public ResponseEntity<?> addusers(@Validated @RequestBody  UsersDTO userDTO, BindingResult binres) {
		List<Roles> roleslist =new ArrayList<>();
		Roles rolesdto =new Roles();
		
		rolesdto.setRole("User");

		roleslist.add(rolesdto);
		userDTO.setRoles(roleslist);
		
		
		
		
		
		if (binres.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : binres.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);
		} else {

			UsersDTO st = usersService.register(userDTO);
			return new ResponseEntity<UsersDTO>(st,HttpStatus.OK);
		}
	}
}
	
	


