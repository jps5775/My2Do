package com.my2do.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my2do.main.model.User;
import com.my2do.main.repo.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserRepo userRepo;

	@GetMapping()
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/{userId}")
	public Optional<User> getUser(@PathVariable long userId) {
		return userRepo.findById(userId);
	}

	@PostMapping()
	public User createUser(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}

	@PutMapping("/{userId}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long userId) {
		Optional<User> userOptional = userRepo.findById(userId);
		if (!userOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userRepo.save(user);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId) {
		userRepo.deleteById(userId);
	}

}
