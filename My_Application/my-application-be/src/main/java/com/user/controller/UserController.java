package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/login")
	public ResponseEntity<User> putEmployee(@RequestParam String userId, @RequestParam String password) {
		System.out.println(userId + "   .... "+password);
		User u1 = service.findByUserId(userId);
		return ResponseEntity.ok(u1);
	}

}
