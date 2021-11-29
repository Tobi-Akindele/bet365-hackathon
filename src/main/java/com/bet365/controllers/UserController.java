package com.bet365.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bet365.dtos.MessageResponse;
import com.bet365.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<?> getUsers(@RequestHeader int page, @RequestHeader int size){
		
		if(page > 0 && size > 0) {
			return ResponseEntity.ok().body(userService.getUsers(page, size));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid pagination values"));
		}
	}
}
