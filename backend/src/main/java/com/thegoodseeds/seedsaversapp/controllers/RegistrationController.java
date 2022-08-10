package com.thegoodseeds.seedsaversapp.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thegoodseeds.seedsaversapp.dtos.request.RegisterUserRequestDto;
import com.thegoodseeds.seedsaversapp.entities.User;
import com.thegoodseeds.seedsaversapp.services.RegistrationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping
	@Operation(summary = "Register an user in the System")
	public ResponseEntity<String> register(@RequestBody RegisterUserRequestDto userDto,UriComponentsBuilder uriBuilder) {
		
		User user  = registrationService.register(userDto);
		
		URI uri = uriBuilder.path("/registration/{id}").buildAndExpand(user.getUserId()).toUri();
		
		String msg = user.getName()+", your account was registered successfully";
		
		return ResponseEntity.created(uri).body(msg);
	}

}
