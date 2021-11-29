package com.bet365.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bet365.dtos.Result;
import com.bet365.models.User;
import com.bet365.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Boolean usernameExists(String username) {
		return userRepository.existsByUsername(username);
	}
	
	public Boolean emailExists(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public User createUser(User user) {
		return userRepository.insert(user);
	}

	public Result<User> getUsers(int page, int size) {
		PageRequest paging = PageRequest.of(page - 1, size);
		Page<User> users = userRepository.findAll(paging);
		return new Result<User>(users.getContent(), users.getNumber(), users.getSize(), users.getNumberOfElements());
	}
}
