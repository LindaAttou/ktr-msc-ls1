package com.app.controller;

import com.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private  UserRepo repo ;

	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {

	 return ResponseEntity.ok(repo.save(user));
		
		
	}

}
