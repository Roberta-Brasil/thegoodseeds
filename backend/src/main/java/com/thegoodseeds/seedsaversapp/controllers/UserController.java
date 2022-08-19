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

import com.thegoodseeds.seedsaversapp.dtos.UserDto;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDto;
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

	@GetMapping("/myseeds/{id}")
	@Operation(summary = "Find seed by id by user")
	public ResponseEntity<SeedResponseDto> findSeedByIdByUser(Principal principal, @PathVariable Long id) {

		SeedResponseDto seedDto = userService.findSeedByIdByUser(principal, id);

		return ResponseEntity.ok().body(seedDto);
	}

	@GetMapping("/myprofile")
	@Operation(summary = "Returns user data")
	public ResponseEntity<UserDto> myProfile(Principal user) {

		UserDto userDto = userService.myProfile(user);

		return ResponseEntity.ok().body(userDto);
	}

	@PutMapping
	@Operation(summary = "Update user data")
	public ResponseEntity<UserDto> update(@RequestBody @Valid UserDto userDto, Principal principal) {

		UserDto userDtoResponse = userService.update(userDto, principal);

		return ResponseEntity.ok().body(userDtoResponse);
	}
}
