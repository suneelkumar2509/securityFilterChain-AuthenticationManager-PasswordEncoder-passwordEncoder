package com.springbootsunilblog.springbootsunilblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsunilblog.springbootsunilblog.DTO.LoginDto;
import com.springbootsunilblog.springbootsunilblog.DTO.UserDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.UsersDTO;
import com.springbootsunilblog.springbootsunilblog.model.Users;
import com.springbootsunilblog.springbootsunilblog.service.UsersService;

public class LoginController {
	

@RestController
@RequestMapping("/api/user")
public class AuthController {

    private   UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }


    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<String> userLogin(@RequestBody LoginDto dto){
    	String login = usersService.userLogin(dto);
		return new ResponseEntity<String> (login,HttpStatus.OK);
    	
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<?> register(@RequestBody UsersDTO loginDto){
    	
        UsersDTO response = usersService.register(loginDto);
        return new ResponseEntity<UsersDTO>(response, HttpStatus.CREATED);
    }
}

}
