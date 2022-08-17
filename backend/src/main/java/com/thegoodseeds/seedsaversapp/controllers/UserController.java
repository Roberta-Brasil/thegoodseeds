package com.thegoodseeds.seedsaversapp.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDto;
import com.thegoodseeds.seedsaversapp.dtos.response.UserResponseDto;
import com.thegoodseeds.seedsaversapp.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/myseeds")
	@Operation(summary = "Find all seeds by user")
	public ResponseEntity<List<SeedResponseDto>> findAllSeedsByUser(Principal user) {
		
		List<SeedResponseDto> seedsDto = userService.findAllSeedsByUser(user);
		
		return ResponseEntity.ok().body(seedsDto);
	}

	@GetMapping("/myprofile")
	@Operation(summary = "Returns user data")
	public ResponseEntity<UserResponseDto> myProfile(Principal user) {
		
		UserResponseDto userDto = userService.myProfile(user);
		
		return ResponseEntity.ok().body(userDto);
	}
	
	
}
