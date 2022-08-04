package com.thegoodseeds.seedsaversapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.repositories.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
	}

}
