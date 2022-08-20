package com.thegoodseeds.seedsaversapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thegoodseeds.seedsaversapp.dtos.UserDTO;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDTO;
import com.thegoodseeds.seedsaversapp.services.UserService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	// This method returns the profile info of the logged user
	@GetMapping("/myprofile")
	@Operation(summary = "Returns user data")
	public ResponseEntity<UserDTO> myProfile(Principal principal) {

		UserDTO userDto = userService.myProfile(principal);

		return ResponseEntity.ok().body(userDto);
	}
    
	// This method returns all seeds added by user
	
	@GetMapping("/myseeds")
	@Operation(summary = "Find all seeds by user")
	public ResponseEntity<List<SeedResponseDTO>> findAllSeedsByUser(Principal principal) {

		List<SeedResponseDTO> seedsDto = userService.findAllSeedsByUser(principal);

		return ResponseEntity.ok().body(seedsDto);
	}

	// This method returns the seeds by id to the logged user
	
	@GetMapping("/myseeds/{id}")
	@Operation(summary = "Find seed by id by user") 
	public ResponseEntity<SeedResponseDTO> findSeedByIdByUser(Principal principal, @PathVariable Long id) {

		SeedResponseDTO seedDto = userService.findSeedByIdByUser(principal, id);

		return ResponseEntity.ok().body(seedDto);
	}

	@PutMapping
	@Operation(summary = "Update user data")
	public ResponseEntity<UserDTO> update( Principal principal , @RequestBody @Valid UserDTO userDTO) {

		UserDTO userDtoResponse = userService.update(principal, userDTO);

		return ResponseEntity.ok().body(userDtoResponse);
	}
}
