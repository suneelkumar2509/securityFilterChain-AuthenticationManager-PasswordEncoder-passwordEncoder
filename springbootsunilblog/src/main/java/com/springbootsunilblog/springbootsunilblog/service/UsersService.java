package com.springbootsunilblog.springbootsunilblog.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springbootsunilblog.springbootsunilblog.DTO.LoginDto;
import com.springbootsunilblog.springbootsunilblog.DTO.UserDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.UsersDTO;
import com.springbootsunilblog.springbootsunilblog.exception.ResourceNotFoundException;
import com.springbootsunilblog.springbootsunilblog.model.Roles;
import com.springbootsunilblog.springbootsunilblog.model.Users;
import com.springbootsunilblog.springbootsunilblog.repository.RolesRepository;
import com.springbootsunilblog.springbootsunilblog.repository.UserRepository;
@Service
public class UsersService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private  RestTemplate resttemplate;
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;


	public UsersService(
			UserRepository userRepository, 
			AuthenticationManager authenticationManager) {
		super();
	
		this.userRepository = userRepository;
		this.authenticationManager = authenticationManager;
	}

	
	public Users getuserbynameoremail(String username ,String email)throws ResourceNotFoundException {
		
		return userRepository .findbyemailorname(username, email) ;
	}
	
	/*
	
	public UsersDTO addusers(UsersDTO usersdto) {
		Users users = modelMapper.map(usersdto, Users.class);
		UsersDTO savedusersDto = null;
		Users savedusers = null;
	
			savedusers = userRepository.save(users);

		
		savedusersDto = modelMapper.map(savedusers, UsersDTO.class);
		return savedusersDto;

	}
	*/
	
	
	public UsersDTO register(UsersDTO loginDto) {

		Users user = new Users();
		user.setUsername(loginDto.getUsername());
		user.setEmail(loginDto.getPassword());
		user.setPassword(passwordEncoder.encode(loginDto.getPassword()));

		List<Roles> roles = new ArrayList<>();
		Roles userRole = rolesRepository.findByrole("ROLE_ADMIN");
		roles.add(userRole);
		
		
		user.setRoles(roles);

	Users newUser=	userRepository.save(user);
UsersDTO newDto=	modelMapper.map(newUser, UsersDTO.class);
		

		return newDto;
		
		
	}
	
	
	public String userLogin(LoginDto loginDto) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return "user login seccufully....";

	}
	
}
