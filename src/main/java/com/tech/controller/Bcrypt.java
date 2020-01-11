package com.tech.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.model.Role;
import com.tech.model.User;
import com.tech.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
public class Bcrypt {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String all() {
		return "<h1>Hello All </h1>";
	}
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public String intro() {
		return "<h1> This is BCrypt password Encoder </h1>";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		return "<h1>Hello Admin </h1>";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user() {
		return "<h1>Hello User </h1>";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@RequestBody User user) { 
		Role role = new Role(); 
		role.setRole("ADMIN");
		
		Set<Role> h = new HashSet<>();
		h.add(role);
		user.setRoles(h);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "user Added";
	}
}
